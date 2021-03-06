package cn.zcoder.xxp.function.ui.activity

import android.os.Bundle
import android.widget.Switch

import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.ui.ToolBar

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :预留电量
 */

class FunctionCommonGActivity : BaseActivity() {



    internal var switchView: Switch? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_fun_common_g
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("预留电量")
                .setOnLeftImageListener({finish()})
    }


}
