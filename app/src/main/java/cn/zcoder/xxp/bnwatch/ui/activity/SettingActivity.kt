package cn.zcoder.xxp.bnwatch.ui.activity

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.CompoundButton
import cn.zcoder.xxp.base.common.Preference
import cn.zcoder.xxp.base.ext.onClick
import cn.zcoder.xxp.base.ext.toast
import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.bnwatch.R
import cn.zcoder.xxp.provider.arouter.RouterPath
import cn.zcoder.xxp.ui.ToolBar
import cn.zcoder.xxp.ui.WarnDialog
import cn.zcoder.xxp.ui.widget.common.Constant
import cn.zcoder.xxp.ui.widget.dialog.TipDialog
import cn.zcoder.xxp.ui.ui.activity.WebActivity
import com.alibaba.android.arouter.launcher.ARouter

import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import kotlinx.android.synthetic.main.activity_setting.*

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/24
 * Description :设置
 */

class SettingActivity : BaseActivity(), CompoundButton.OnCheckedChangeListener, View.OnClickListener {


    /**
     * 地图类型
     */
    private var mMapType by Preference(Constant.MapType.MAP_TYPE, Constant.MapType.MAP_TYPE_BAIDU)

    override fun getLayoutId(): Int {
        return R.layout.activity_setting
    }


    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("设置")
                .setOnLeftImageListener({ finish() })
    }

    override fun bindListener() {
        super.bindListener()
        switchView.setOnCheckedChangeListener(this)
        rlMsg.onClick(this)
        rlModifyPwd.onClick(this)
        rlModifyMap.onClick(this)
        rlCleanCache.onClick(this)
        rlAboutUs.onClick(this)
        btnLogout.onClick(this)
    }

    override fun initData() {
        when (mMapType) {
            Constant.MapType.MAP_TYPE_BAIDU -> tvMapType.text = String.format("当前: %s", "百度地图")
            Constant.MapType.MAP_TYPE_GOOGLE -> tvMapType.text = String.format("当前: %s", "谷歌地图")
        }


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.rlMsg -> {
            }
            R.id.rlModifyPwd -> ARouter.getInstance().build(RouterPath.UserCenter.PATH_MOD_PWD).navigation()
            R.id.rlModifyMap -> if (GoogleApiAvailability.getInstance()
                            .isGooglePlayServicesAvailable(applicationContext) != ConnectionResult.SUCCESS) {
                toast(R.string.not_google_play)
                mMapType = Constant.MapType.MAP_TYPE_BAIDU
            } else {
                var currentMapName = ""
                when (mMapType) {
                    Constant.MapType.MAP_TYPE_BAIDU -> {
                        currentMapName = "谷歌地图"
                        mMapType = Constant.MapType.MAP_TYPE_GOOGLE
                    }
                    Constant.MapType.MAP_TYPE_GOOGLE -> {
                        currentMapName = "百度地图"
                        mMapType = Constant.MapType.MAP_TYPE_BAIDU
                    }
                }
                tvMapType.text = String.format("当前: %s", currentMapName)
                toast(String.format("切换成功!当前: %s", currentMapName))
            }
            R.id.rlCleanCache -> {
                toast("清理中...")
                Handler().postDelayed({ TipDialog.show("清理完成", supportFragmentManager) }, 3000)
            }
            R.id.rlAboutUs -> WebActivity.startAction(this, "关于我们","http://video.browser.qq.com/?ADTAG=newtabweb")
            R.id.btnLogout -> {
                val dialog = WarnDialog.show(supportFragmentManager, "警告", "确定退出?")
                dialog.setOnClickListener(object : WarnDialog.OnClickListener {
                    override fun onConfirm() {

                    }

                    override fun onCancel() {

                    }
                })
            }
        }
    }


    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        tvStatus.text = getString(if (isChecked) R.string.opened else R.string.closed)
    }


}
