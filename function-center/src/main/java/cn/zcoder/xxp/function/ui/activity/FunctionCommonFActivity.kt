package cn.zcoder.xxp.function.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Switch

import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.ui.widget.ToolBar

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :自动接通
 */

class FunctionCommonFActivity : BaseActivity() {

    internal var switchView: Switch? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_fun_common_f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("自动接通")
                .setOnLeftImageListener({finish()})
    }

    companion object {

        fun startAction(context: Context) {
            context.startActivity(Intent(context, FunctionCommonFActivity::class.java))
        }
    }

}
