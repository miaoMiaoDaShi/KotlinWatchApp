package cn.zcoder.xxp.location.ui.fragment

import android.support.v4.app.Fragment
import cn.zcoder.xxp.location.listener.MapControlListener
import cn.zcoder.xxp.ui.widget.map.base.BaseBaiduMapFragment
import com.baidu.mapapi.map.MapStatusUpdateFactory


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description : 定位 百度地图
 */


class LocationBaiduMapFragment : BaseBaiduMapFragment(), MapControlListener {
    override fun onZoomOut() {
        baiduMap.animateMapStatus(MapStatusUpdateFactory.zoomOut())

    }

    override fun onZoomIn() {

        baiduMap.animateMapStatus(MapStatusUpdateFactory.zoomIn())
    }

    override fun onMapLoaded() {
        getMapView().showZoomControls(false)
    }

    companion object {
        fun newInstance(): LocationBaiduMapFragment {
            return LocationBaiduMapFragment()
        }
    }
}
