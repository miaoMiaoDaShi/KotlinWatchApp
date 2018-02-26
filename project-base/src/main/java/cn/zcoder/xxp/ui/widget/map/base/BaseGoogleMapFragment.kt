package cn.zcoder.xxp.ui.widget.map.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import cn.zcoder.xxp.base.ui.fragment.BaseFragment
import cn.zcoder.xxp.ui.R

/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/11/8
 * Description : googleMap
 */


abstract class BaseGoogleMapFragment : BaseFragment(), OnMapReadyCallback {


    lateinit var googleMap: GoogleMap
        private set


    override fun getLayoutId(): Int {
        return  R.layout.fragment_google_map
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(getLayoutId(), container, false)
        val mapFragment = childFragmentManager
                .findFragmentById(R.id.googleMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
        return rootView
    }



    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        onMapReady()
    }

    protected abstract fun onMapReady()


}
