package cn.zcoder.xxp.function.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView


import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.ui.widget.ToolBar

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :上学守护
 */

class GoToSchoolTimeActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_go_to_school_time
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
        .setTitle("设置时间段")
                .setOnLeftImageListener({finish()})
                .setOnRightTextListener(getString(R.string.save),{save()})
    }

    /**
     * 保存
     */
    private fun save() {

    }

    companion object {
        //    @BindView(R.id.tvAmTime)
        //    TextView tvAmTime;
        //    @BindView(R.id.tvAmStartTime)
        //    TextView tvAmStartTime;
        //    @BindView(R.id.tvAmStopTime)
        //    TextView tvAmStopTime;
        //    @BindView(R.id.tvPmTime)
        //    TextView tvPmTime;
        //    @BindView(R.id.tvPmStartTime)
        //    TextView tvPmStartTime;
        //    @BindView(R.id.tvPmStopTime)
        //    TextView tvPmStopTime;
        //    @BindView(R.id.tvGoHomeTime)
        //    TextView tvGoHomeTime;
        //    @BindView(R.id.tvRepetitionType)
        //    TextView tvRepetitionType;

        fun startAction(context: Context) {
            context.startActivity(Intent(context, GoToSchoolTimeActivity::class.java))
        }
    }


    //    @OnClick({R.id.tvAmTime, R.id.tvAmStartTime, R.id.tvAmStopTime, R.id.tvPmTime, R.id.tvPmStartTime, R.id.tvPmStopTime, R.id.tvGoHomeTime, R.id.tvRepetitionType})
    //    public void onViewClicked(View view) {
    //        switch (view.getId()) {
    //            case R.id.tvAmTime:
    //                break;
    //            case R.id.tvAmStartTime:
    //                break;
    //            case R.id.tvAmStopTime:
    //                break;
    //            case R.id.tvPmTime:
    //                break;
    //            case R.id.tvPmStartTime:
    //                break;
    //            case R.id.tvPmStopTime:
    //                break;
    //            case R.id.tvGoHomeTime:
    //                break;
    //            case R.id.tvRepetitionType:
    //                break;
    //            default:
    //        }
    //    }
}
