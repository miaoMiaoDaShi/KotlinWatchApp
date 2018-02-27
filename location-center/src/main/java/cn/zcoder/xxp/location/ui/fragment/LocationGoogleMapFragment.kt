package cn.zcoder.xxp.location.ui.fragment

import android.support.v4.app.Fragment
import cn.zcoder.xxp.location.listener.MapControlListener
import cn.zcoder.xxp.ui.widget.map.base.BaseGoogleMapFragment
import com.google.android.gms.maps.CameraUpdateFactory


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description : 定位  googleMap
 */


class LocationGoogleMapFragment : BaseGoogleMapFragment(),MapControlListener {
    override fun onZoomIn() {
        googleMap.animateCamera(CameraUpdateFactory.zoomIn())

    }

    override fun onZoomOut() {
        googleMap.animateCamera(CameraUpdateFactory.zoomOut())
    }

    protected override fun onMapReady() {

    }

    companion object {
        fun newInstance(): LocationGoogleMapFragment {
            return LocationGoogleMapFragment()
        }
    }
}
