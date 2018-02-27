package cn.zcoder.xxp.function.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import cn.zcoder.xxp.base.common.Preference
import cn.zcoder.xxp.base.ext.toast

import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability


import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.function.ui.fragment.SelectAddrsBaiduMapFragment
import cn.zcoder.xxp.function.ui.fragment.SelectAddrsGoogleMapFragment
import cn.zcoder.xxp.ui.ToolBar
import cn.zcoder.xxp.ui.widget.common.Constant


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/30
 * Description : 在地图上选择位置
 */


class SelectAddrsActivity : BaseActivity() {
    //地图类型
    private var mMapType by Preference(Constant.MapType.MAP_TYPE, 0)
    private val mFragmentManager: FragmentManager by lazy {
        supportFragmentManager
    }
    private val mGoogleMapFragment: Fragment by lazy {
        SelectAddrsGoogleMapFragment.newInstance()
    }
    private val mBaiduMapFragment: Fragment by lazy {
        SelectAddrsBaiduMapFragment.newInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("设置地址")
                .setOnLeftImageListener({ finish() })
                .setOnRightTextListener("保存", { save() })


    }

    private fun save() {

    }


    override fun getLayoutId(): Int {
        return R.layout.activity_select_addrs
    }

    override fun start() {
        super.start()
    }



    override fun onResume() {
        super.onResume()
        setUpMap()
    }

    /**
     * 开始加载地图
     */
    private fun setUpMap() {
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(applicationContext) != ConnectionResult.SUCCESS) {
            toast(R.string.not_google_play)
            mMapType = Constant.MapType.MAP_TYPE_BAIDU
        }
        when (mMapType) {
            Constant.MapType.MAP_TYPE_BAIDU -> setUpBaiduMap()
            Constant.MapType.MAP_TYPE_GOOGLE -> setUpGoogleMap()
        }
    }

    /**
     * 百度地图初始化
     */
    private fun setUpBaiduMap() {
        val baiduTransaction = mFragmentManager.beginTransaction()
        baiduTransaction.replace(R.id.flMaps, mBaiduMapFragment)
        baiduTransaction.commitAllowingStateLoss()

    }

    /**
     * googleMap初始化
     */
    private fun setUpGoogleMap() {
        val googleTransaction = mFragmentManager.beginTransaction()
        googleTransaction.replace(R.id.flMaps, mGoogleMapFragment)
        googleTransaction.commitAllowingStateLoss()
        //getLocationName(30.67, 106.04)
    }


    fun onLoadAddrsNameSuccess() {

    }

    fun onLoadAddrsNameError() {

    }

}
