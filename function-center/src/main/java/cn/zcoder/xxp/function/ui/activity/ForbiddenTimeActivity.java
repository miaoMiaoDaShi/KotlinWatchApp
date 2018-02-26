package cn.zcoder.xxp.function.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import cn.zcoder.xxp.base.ui.activity.BaseActivity;
import cn.zcoder.xxp.function.R;
import cn.zcoder.xxp.ui.widget.ToolBar;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :上学守护
 */

public class ForbiddenTimeActivity extends BaseActivity {

    ToolBar toolBar;
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


    public static void startAction(Context context) {
        context.startActivity(new Intent(context, ForbiddenTimeActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forbidden_time;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolBar.setTitle("添加禁用时间")
                .setOnLeftImageListener(new ToolBar.OnLeftImageListener() {
                    @Override
                    public void onClick() {
                        finish();
                    }
                });
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
