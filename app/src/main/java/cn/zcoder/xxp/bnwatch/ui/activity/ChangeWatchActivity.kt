package cn.zcoder.xxp.bnwatch.ui.activity

import android.os.Bundle


import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.bnwatch.R
import cn.zcoder.xxp.ui.ToolBar

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/24
 * Description :切换手表
 */

class ChangeWatchActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_switch_watch
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("切换")
                .setOnLeftImageListener({ finish() })
    }

}
