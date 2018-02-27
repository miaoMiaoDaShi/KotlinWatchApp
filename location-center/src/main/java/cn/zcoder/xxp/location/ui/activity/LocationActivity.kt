package cn.zcoder.xxp.location.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import cn.zcoder.xxp.base.common.Preference
import cn.zcoder.xxp.base.ext.onClick
import cn.zcoder.xxp.base.ext.toast
import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.location.R
import cn.zcoder.xxp.location.listener.MapControlListener
import cn.zcoder.xxp.location.ui.fragment.LocationBaiduMapFragment
import cn.zcoder.xxp.location.ui.fragment.LocationGoogleMapFragment
import cn.zcoder.xxp.ui.ToolBar
import cn.zcoder.xxp.ui.widget.common.Constant
import com.alibaba.android.arouter.facade.annotation.Route

import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability

import kotlinx.android.synthetic.main.activity_location.*


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/24
 * Description :首页点进去定位
 */
@Route(path = "/locationCenter/main")
class LocationActivity : BaseActivity(), View.OnClickListener {


//    @BindView(R.id.flMaps)
//    internal var flMaps: FrameLayout? = null
//    @BindView(R.id.tvBabyLocation)
//    internal var tvBabyLocation: TextView? = null
//    @BindView(R.id.tvTime)
//    internal var tvTime: TextView? = null
//    @BindView(R.id.tvHighPrecision)
//    internal var tvHighPrecision: TextView? = null
//    @BindView(R.id.tvAddrs)
//    internal var tvAddrs: TextView? = null
//    @BindView(R.id.ivPortrait)
//    internal var ivPortrait: CircleImageView? = null
//    @BindView(R.id.tvStatus)
//    internal var tvStatus: TextView? = null
//    @BindView(R.id.tvStepUnm)
//    internal var tvStepUnm: TextView? = null
//    @BindView(R.id.llBottomBlock)
//    internal var llBottomBlock: LinearLayout? = null

    //地图类型
    private var mMapType by Preference(Constant.MapType.MAP_TYPE, Constant.MapType.MAP_TYPE_BAIDU)
    private val mFragmentManager: FragmentManager by lazy {
        supportFragmentManager
    }
    private val mGoogleMapFragment by lazy {
        LocationGoogleMapFragment.newInstance()
    }
    private val mBaiduMapFragment by lazy {
        LocationBaiduMapFragment.newInstance()
    }

    private var mCurrentControlMap: MapControlListener? = null


    override fun getLayoutId(): Int {
        return R.layout.activity_location

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle(getString(R.string.location))
                .setOnLeftImageListener({ finish() })
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
        mCurrentControlMap = when (mMapType) {
            Constant.MapType.MAP_TYPE_BAIDU -> setUpBaiduMap()
            Constant.MapType.MAP_TYPE_GOOGLE -> setUpGoogleMap()
            else -> {
                null
                throw RuntimeException("map is null")
            }
        }
    }

    /**
     * 百度地图初始化
     */
    private fun setUpBaiduMap(): MapControlListener {
        val baiduTransaction = mFragmentManager.beginTransaction()
        baiduTransaction.replace(R.id.flMaps, mBaiduMapFragment)
        baiduTransaction.commitAllowingStateLoss()
        return mBaiduMapFragment
    }

    /**
     * googleMap初始化
     */
    private fun setUpGoogleMap(): MapControlListener {
        val googleTransaction = mFragmentManager.beginTransaction()
        googleTransaction.replace(R.id.flMaps, mGoogleMapFragment)
        googleTransaction.commitAllowingStateLoss()
        return mGoogleMapFragment
        //getLocationName(30.67, 106.04)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivNavigation -> {
            }
            R.id.btnBlowUp -> {
                mCurrentControlMap?.onZoomIn()
            }
            R.id.btnZoomOut -> {
                mCurrentControlMap?.onZoomOut()
            }
            else -> {
            }
        }
    }

    override fun bindListener() {
        super.bindListener()
        ivNavigation.onClick(this)
        btnBlowUp.onClick(this)
        btnZoomOut.onClick(this)
    }


}
