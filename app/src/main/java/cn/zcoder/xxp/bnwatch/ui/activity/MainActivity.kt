package cn.zcoder.xxp.bnwatch.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import android.widget.Toast
import cn.zcoder.xxp.base.Configurator.okHttpClient
import cn.zcoder.xxp.base.common.Preference
import cn.zcoder.xxp.base.ext.onClick
import cn.zcoder.xxp.base.ext.toast
import cn.zcoder.xxp.base.net.RetrofitClient
import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.bnwatch.R
import cn.zcoder.xxp.bnwatch.common.Constant
import cn.zcoder.xxp.bnwatch.ui.fragment.HomeBaiduMapFragment
import cn.zcoder.xxp.bnwatch.ui.fragment.HomeGoogleMapFragment
import cn.zcoder.xxp.provider.arouter.RouterPath
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.observers.DisposableObserver
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import org.jetbrains.anko.startActivity
import timber.log.Timber
import java.io.IOException


class MainActivity : BaseActivity(), View.OnClickListener {


    //地图类型
    private var mMapType by Preference(Constant.MapType.MAP_TYPE, 0)
    private var mCurrentMapType = -1
    private val mFragmentManager by lazy {
        supportFragmentManager
    }
    private var mGoogleMapFragment: Fragment? = null
    private var mBaiduMapFragment: Fragment? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        initBottomTab()
    }

    /**
     * 底部的3个tab
     */
    private fun initBottomTab() {
        val tabTitls = resources.getStringArray(R.array.home_bottom_tabs)
        tvTabA.text = tabTitls[0]
        tvTabB.text = tabTitls[1]
        tvTabC.text = tabTitls[2]
    }


    override fun bindListener() {
        super.bindListener()
        //点击进入个人中心
        llMine.onClick(this)
        //点击进入消息中心
        ivMsgStatus.onClick(this)
        //点击进入功能模块中心
        llFunction.onClick(this)
        //点击进入定位模块
        tvTabA.onClick(this)
        //点击进入打电话
        tvTabB.onClick(this)
        //点击进入语聊模块
        tvTabC.onClick(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.llMine -> {
                startActivity<MineActivity>()
            }
            R.id.ivMsgStatus -> {
            }
            R.id.llFunction -> {
                ARouter.getInstance().build(RouterPath.FunctionCenter.PATH_FUNCTION).navigation()
            }
            R.id.tvTabA -> {
            }
            R.id.tvTabB -> {
            }
            R.id.tvTabC -> {
            }
            else -> {
            }
        }
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
        mCurrentMapType = mMapType
    }

    override protected fun onResume() {
        super.onResume()
        if (mMapType != mCurrentMapType) {
            setUpMap()
        }
    }

    /**
     * 百度地图初始化
     */
    private fun setUpBaiduMap() {
        mBaiduMapFragment = HomeBaiduMapFragment.newInstance()
        val baiduTransaction = mFragmentManager.beginTransaction()
        baiduTransaction.replace(R.id.flMaps, mBaiduMapFragment)
        baiduTransaction.commitAllowingStateLoss()

    }

    /**
     * googleMap初始化
     */
    private fun setUpGoogleMap() {
        mGoogleMapFragment = HomeGoogleMapFragment.newInstance()
        val googleTransaction = mFragmentManager.beginTransaction()
        googleTransaction.replace(R.id.flMaps, mGoogleMapFragment)
        googleTransaction.commitAllowingStateLoss()
        getLocationName(30.67, 106.04)
    }

    /**
     * 根据坐标获取位置name
     * @param lat
     * @param lng
     */
    private fun getLocationName(lat: Double, lng: Double) {
        Observable.create(ObservableOnSubscribe<String> { observableEmitter ->
            val request = Request.Builder()
                    .get()
                    .url("http://api.map.baidu.com/cloudrgc/v1?location=" + lat + ","
                            + lng + "&ak=HcqD98UrwBSK3X7sI4Osa9uu6gyNjZ9K&geotable_id=" +
                            "184418" +
                            "&mcode=4C:BB:66:4A:42:C4:AD:F9:DD:43:7F:0C:72:DF:9F:CB:AB:E4:99:18;cn.zcoder.xxp.bnwatch")
                    .build()
            val call = okHttpClient.newCall(request)
            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    observableEmitter.onError(e)
                    //onError(e)
                }

                @Throws(IOException::class)
                override fun onResponse(call: Call, response: Response) {
                    Timber.i(response.body()!!.string())
                    observableEmitter.onNext(response.toString())
                }
            })
        })
                .compose(RetrofitClient.SCHEDULERS_TRANSFORMER)
                .subscribeWith(object : DisposableObserver<String>() {
                    override fun onNext(s: String) {
                        Timber.i(s)
                        toast(s)
                    }

                    override fun onError(e: Throwable) {
                        Timber.e(e)
                    }

                    override fun onComplete() {

                    }
                } as DisposableObserver<Any>)

    }
}


