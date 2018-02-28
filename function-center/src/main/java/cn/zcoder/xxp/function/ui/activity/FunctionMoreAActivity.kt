package cn.zcoder.xxp.function.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.TextView
import cn.zcoder.xxp.base.ext.onClick


import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.ui.ToolBar
import kotlinx.android.synthetic.main.activity_fun_more_a.*
import org.jetbrains.anko.startActivity

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :手表设置
 */

class FunctionMoreAActivity : BaseActivity(),View.OnClickListener {



    override fun getLayoutId(): Int {
        return R.layout.activity_fun_more_a
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("手表设置")
                .setOnLeftImageListener({finish()})
    }

    override fun bindListener() {
        super.bindListener()
        rlLightTime.onClick(this)
        rlSoundSnake.onClick(this)
        rlHourType.onClick(this)
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.rlLightTime-> {
                startActivity<LightTimeSelectActivity>()
            }
            R.id.rlSoundSnake->{
                startActivity<SoundAndSnakeActivity>()
            }
            R.id.rlHourType->{
                mSwitchView.toggle()
            }
            else -> {
            }
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
