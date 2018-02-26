package cn.zcoder.xxp.function.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.TextView


import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.ui.widget.ToolBar

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :手表设置
 */

class FunctionMoreAActivity : BaseActivity() {

    internal var tvLightTime: TextView? = null
    internal var switchView: Switch? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_fun_more_a
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("手表设置")
                .setOnLeftImageListener({finish()})
    }

    companion object {

        fun startAction(context: Context) {
            context.startActivity(Intent(context, FunctionMoreAActivity::class.java))
        }
    }

    //    @OnClick({R.id.rlLightTime, R.id.rlSoundSnake, R.id.rlHourType})
    //    public void onViewClicked(View view) {
    //        switch (view.getId()) {
    //            case R.id.rlLightTime:
    //                break;
    //            case R.id.rlSoundSnake:
    //                SoundAndSnakeActivity.startAction(this);
    //                break;
    //            case R.id.rlHourType:
    //                switchView.toggle();
    //                break;
    //            default:
    //        }
    //    }
}
