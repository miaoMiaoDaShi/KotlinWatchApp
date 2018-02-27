package cn.zcoder.xxp.function.ui.activity

import android.os.Bundle
import android.view.View
import cn.zcoder.xxp.base.ext.onClick

import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.ui.ToolBar
import kotlinx.android.synthetic.main.activity_fun_b.*
import org.jetbrains.anko.startActivity

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :上学守护
 */

class FunctionBActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mRlGoToSchoolTime -> {
                startActivity<GoToSchoolTimeActivity>()
            }
            R.id.mRlSchoolAddrs -> {
                startActivity<SelectAddrsActivity>()
            }
            R.id.mRlHomeAddrs -> {
                startActivity<SelectAddrsActivity>()
            }
            R.id.mRlWifi -> {

            }
            else -> {
            }
        }
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_fun_b
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("上学守护")
                .setOnLeftImageListener({ finish() })
    }

    override fun bindListener() {
        super.bindListener()
        mRlGoToSchoolTime.onClick(this)
        mRlSchoolAddrs.onClick(this)
        mRlHomeAddrs.onClick(this)
        mRlWifi.onClick(this)
    }

}
