package cn.zcoder.xxp.function.ui.fragment

import android.graphics.Point
import android.support.v4.app.Fragment
import cn.zcoder.xxp.base.utils.GPSUtil
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.function.ui.activity.SelectAddrsActivity
import cn.zcoder.xxp.ui.SelectAddrsView
import cn.zcoder.xxp.ui.getLocationName
import cn.zcoder.xxp.ui.widget.map.base.BaseGoogleMapFragment

import com.baidu.mapapi.utils.DistanceUtil
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import kotlinx.android.synthetic.main.fragment_sel_addrs_google_map.*


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description : 定位  googleMap
 */


class SelectAddrsGoogleMapFragment : BaseGoogleMapFragment(), SelectAddrsView.OnZoomListener, GoogleMap.OnCameraMoveListener, GoogleMap.OnMapClickListener, GoogleMap.OnMarkerDragListener {


    override fun getLayoutId(): Int {
        return R.layout.fragment_sel_addrs_google_map
    }

    protected override fun onMapReady() {
        mSelectAddrsView.setOnZoomListener(this)
        googleMap.setOnCameraMoveListener(this)
        googleMap.setOnMapClickListener(this)
        googleMap.setOnMarkerDragListener(this)

    }


    override fun getScope(centerPoint: Point, radius: Float): Float {
        val projection = googleMap.getProjection()
        val centerLatLng = projection.fromScreenLocation(centerPoint)
        val marginLatLng = projection.fromScreenLocation(Point(centerPoint.x + radius.toInt(),
                centerPoint.y + radius.toInt()))

        return DistanceUtil.getDistance(com.baidu.mapapi.model.LatLng(centerLatLng.latitude, centerLatLng.longitude),
                com.baidu.mapapi.model.LatLng(marginLatLng.latitude, marginLatLng.longitude)).toFloat()
    }


    /**
     * 根据经纬度得到地址
     *
     * @param centerPoint
     */
    private fun loadLocationName(centerPoint: Point) {
        val projection = googleMap.getProjection()
        val centerLatLng = projection.fromScreenLocation(centerPoint)
        getLocationName(GPSUtil.gcj02_To_Bd09(centerLatLng.latitude, centerLatLng.longitude)[0],
                GPSUtil.gcj02_To_Bd09(centerLatLng.latitude, centerLatLng.longitude)[1],
                { (activity as SelectAddrsActivity).onLoadAddrsNameSuccess() },
                { (activity as SelectAddrsActivity).onLoadAddrsNameError() })
    }

    override fun onCameraMove() {
        mSelectAddrsView.invalidate()
    }

    override fun onMapClick(latLng: LatLng) {
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng))
    }

    override fun onMarkerDragStart(marker: Marker) {

    }

    override fun onMarkerDrag(marker: Marker) {

    }

    override fun onMarkerDragEnd(marker: Marker) {
        loadLocationName(mSelectAddrsView.getCenterPoint())
    }

    companion object {

        fun newInstance(): Fragment {
            return SelectAddrsGoogleMapFragment()
        }
    }
}
