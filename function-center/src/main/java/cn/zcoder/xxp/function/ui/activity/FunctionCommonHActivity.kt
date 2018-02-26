package cn.zcoder.xxp.function.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Switch

import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.ui.widget.ToolBar

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :语音提示
 */

class FunctionCommonHActivity : BaseActivity() {

    internal var switchViewAsr: Switch? = null
    internal var switchViewBroadcast: Switch? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_fun_common_h
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("语音提示")
                .setOnLeftImageListener({finish()})
    }

    companion object {

        fun startAction(context: Context) {
            context.startActivity(Intent(context, FunctionCommonHActivity::class.java))
        }
    }

    //    @OnClick({R.id.rlAsr, R.id.rlBroadcast})
    //    public void onViewClicked(View view) {
    //        switch (view.getId()) {
    //            case R.id.rlAsr:
    //                break;
    //            case R.id.rlBroadcast:
    //                break;
    //        }
    //    }
}
