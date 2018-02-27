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
 * Description :手表挂失
 */

class FunctionMoreDActivity : BaseActivity() {

    internal var switchView: Switch? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_fun_more_d
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("手表挂失").setOnLeftImageListener({finish()})
    }


}
