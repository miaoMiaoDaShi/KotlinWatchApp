package cn.zcoder.xxp.function.ui.fragment

import android.graphics.Point
import android.support.v4.app.Fragment
import android.view.MotionEvent
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.function.ui.activity.SelectAddrsActivity
import cn.zcoder.xxp.ui.SelectAddrsView
import cn.zcoder.xxp.ui.getLocationName
import cn.zcoder.xxp.ui.widget.map.base.BaseBaiduMapFragment

import com.baidu.mapapi.map.BaiduMap
import com.baidu.mapapi.map.MapPoi
import com.baidu.mapapi.map.MapStatus
import com.baidu.mapapi.map.MapStatusUpdateFactory
import com.baidu.mapapi.model.LatLng
import com.baidu.mapapi.utils.DistanceUtil
import kotlinx.android.synthetic.main.fragment_sel_addrs_baidu_map.*


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description : 定位 百度地图
 */


class SelectAddrsBaiduMapFragment : BaseBaiduMapFragment(), SelectAddrsView.OnZoomListener,
        BaiduMap.OnMapStatusChangeListener, BaiduMap.OnMapClickListener, BaiduMap.OnMapTouchListener {

    override fun getLayoutId(): Int {
        return R.layout.fragment_sel_addrs_baidu_map
    }

    override fun onMapLoaded() {
        mSelectAddrsView.setOnZoomListener(this)
        baiduMap.setOnMapStatusChangeListener(this)
        baiduMap.setOnMapClickListener(this)
        baiduMap.setOnMapTouchListener(this)
        mSelectAddrsView.invalidate()
        loadLocationName(mSelectAddrsView.getCenterPoint())


    }

    /**
     * 根据经纬度得到地址
     *
     * @param centerPoint
     */
    private fun loadLocationName(centerPoint: Point) {
        val projection = baiduMap.getProjection()
        val centerLatLng = projection.fromScreenLocation(centerPoint)
        getLocationName(centerLatLng.latitude, centerLatLng.longitude,
                { (activity as SelectAddrsActivity).onLoadAddrsNameSuccess() },
                { (activity as SelectAddrsActivity).onLoadAddrsNameError() })
    }

    override fun getScope(centerPoint: Point, radius: Float): Float {
        val projection = baiduMap.getProjection()
        val centerLatLng = projection.fromScreenLocation(centerPoint)
        val marginLatLng = projection.fromScreenLocation(Point(centerPoint.x + radius.toInt(),
                centerPoint.y + radius.toInt()))

        return DistanceUtil.getDistance(centerLatLng, marginLatLng).toFloat()
    }


    override fun onMapStatusChangeStart(mapStatus: MapStatus) {

    }

    override fun onMapStatusChangeStart(mapStatus: MapStatus, i: Int) {

    }

    override fun onMapStatusChange(mapStatus: MapStatus) {

    }

    override fun onMapStatusChangeFinish(mapStatus: MapStatus) {
        mSelectAddrsView.invalidate()
    }

    override fun onMapClick(latLng: LatLng) {
        baiduMap.animateMapStatus(MapStatusUpdateFactory.newLatLng(latLng))
    }

    override fun onMapPoiClick(mapPoi: MapPoi): Boolean {
        return false
    }


    override fun onTouch(motionEvent: MotionEvent) {
        when (motionEvent.action) {
            MotionEvent.ACTION_UP -> loadLocationName(mSelectAddrsView.getCenterPoint())
        }
    }

    companion object {

        fun newInstance(): Fragment {
            return SelectAddrsBaiduMapFragment()
        }
    }
}
