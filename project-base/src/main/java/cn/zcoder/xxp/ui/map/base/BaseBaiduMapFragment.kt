package cn.zcoder.xxp.ui.widget.map.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.baidu.mapapi.map.BaiduMap

import cn.zcoder.xxp.base.ui.fragment.BaseFragment
import cn.zcoder.xxp.ui.R
import kotlinx.android.synthetic.main.fragment_baidu_map.*

/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/11/8
 * Description : BaiduMap
 */


abstract class BaseBaiduMapFragment : BaseFragment(), BaiduMap.OnMapLoadedCallback {
    lateinit var baiduMap: BaiduMap

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(getLayoutId(), container, false)
        return rootView
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        baiduMap = mMapView.map
        baiduMap.setOnMapLoadedCallback(this)
    }

    protected fun getMapView() = mMapView

    override fun onPause() {
        super.onPause()
        mMapView.onPause()
    }

    override fun onResume() {
        super.onResume()
        mMapView.onResume()
    }


    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mMapView.apply {
            onDestroy()
            baiduMap.clear()
        }

    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_baidu_map
    }

}
