package cn.zcoder.xxp.bnwatch.ui.fragment

import cn.zcoder.xxp.bnwatch.ui.activity.MainActivity
import cn.zcoder.xxp.ui.widget.map.base.BaseGoogleMapFragment


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/26
 * Description :
 */

class HomeGoogleMapFragment : BaseGoogleMapFragment() {

    companion object {
        fun newInstance() = HomeGoogleMapFragment()
    }

    override fun onMapReady() {
        googleMap.setOnMapClickListener { (activity as MainActivity).onMapClick() }
    }
}