package cn.zcoder.xxp.bnwatch.ui.fragment

import cn.zcoder.xxp.bnwatch.ui.activity.MainActivity
import cn.zcoder.xxp.ui.widget.map.base.BaseBaiduMapFragment
import com.baidu.mapapi.map.BaiduMap
import com.baidu.mapapi.map.MapPoi
import com.baidu.mapapi.model.LatLng


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/26
 * Description :
 */

class HomeBaiduMapFragment:BaseBaiduMapFragment(), BaiduMap.OnMapClickListener {
    override fun onMapPoiClick(p0: MapPoi?): Boolean {
        return false

    }

    override fun onMapClick(p0: LatLng?) {
        ( activity as MainActivity).onMapClick()

    }

    companion object {
        fun newInstance() = HomeBaiduMapFragment()
    }
    override fun onMapLoaded() {
        baiduMap.setOnMapClickListener(this)
    }
}