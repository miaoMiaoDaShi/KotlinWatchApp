package cn.zcoder.xxp.function.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.widget.FrameLayout
import android.widget.TextView

import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.gson.Gson


import java.io.IOException


import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.ui.widget.ToolBar
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.observers.DisposableObserver
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import timber.log.Timber


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/30
 * Description : 在地图上选择位置
 */


class SelectAddrsActivity : BaseActivity() {

    internal var tvCurrentAddrs: TextView? = null
    internal var flMaps: FrameLayout? = null
    //地图类型
    private val mMapType = -1
    private val mFragmentManager: FragmentManager? = null
    private val mGoogleMapFragment: Fragment? = null
    private val mBaiduMapFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("设置地址")
                .setOnLeftImageListener({finish()})
                .setOnRightTextListener("保存", {save()})


    }

    private fun save() {

    }


    override fun getLayoutId(): Int {
        return R.layout.activity_select_addrs
    }



}
