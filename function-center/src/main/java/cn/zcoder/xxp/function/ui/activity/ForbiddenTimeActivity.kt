package cn.zcoder.xxp.function.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle


import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.ui.ToolBar

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :上学守护
 */

class ForbiddenTimeActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_forbidden_time
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("添加禁用时间")
                .setOnLeftImageListener({finish()})
    }

    companion object {
        //    @BindView(R.id.tvTimeName)
        //    TextView tvTimeName;
        //    @BindView(R.id.tvAmStartTime)
        //    TextView tvAmStartTime;
        //    @BindView(R.id.tvAmStopTime)
        //    TextView tvAmStopTime;
        //    @BindView(R.id.tvPmStartTime)
        //    TextView tvPmStartTime;
        //    @BindView(R.id.tvPmStopTime)
        //    TextView tvPmStopTime;
        //    @BindView(R.id.tvRepetitionType)
        //    TextView tvRepetitionType;


        fun startAction(context: Context) {
            context.startActivity(Intent(context, ForbiddenTimeActivity::class.java))
        }
    }


    //    @OnClick({R.id.tvTimeName, R.id.tvAmStartTime, R.id.tvAmStopTime, R.id.tvPmStartTime, R.id.tvPmStopTime, R.id.tvRepetitionType, R.id.btnSave})
    //    public void onViewClicked(View view) {
    //        switch (view.getId()) {
    //            case R.id.tvTimeName:
    //                break;
    //            case R.id.tvAmStartTime:
    //                break;
    //            case R.id.tvAmStopTime:
    //                break;
    //            case R.id.tvPmStartTime:
    //                break;
    //            case R.id.tvPmStopTime:
    //                break;
    //            case R.id.tvRepetitionType:
    //                break;
    //            case R.id.btnSave:
    //                break;
    //            default:
    //        }
    //    }
}
