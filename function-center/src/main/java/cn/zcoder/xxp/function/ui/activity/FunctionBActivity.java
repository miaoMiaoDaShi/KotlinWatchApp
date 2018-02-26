package cn.zcoder.xxp.function.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
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

public class FunctionBActivity extends BaseActivity {

    ToolBar toolBar;
    Switch switchView;
//    TextView tvGoToSchoolTime;
//    TextView tvSchoolAddrs;
//    TextView tvHomeAddrs;
//    TextView tvWifi;

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, FunctionBActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fun_b;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolBar.setTitle("上学守护")
                .setOnLeftImageListener(new ToolBar.OnLeftImageListener() {
                    @Override
                    public void onClick() {
                        finish();
                    }
                });
    }

//    @OnClick({R.id.rlGoToSchoolTime, R.id.rlSchoolAddrs, R.id.rlHomeAddrs, R.id.rlWifi})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.rlGoToSchoolTime:
//                break;
//            case R.id.rlSchoolAddrs:
//                SelectAddrsActivity.startAction(this);
//                break;
//            case R.id.rlHomeAddrs:
//                SelectAddrsActivity.startAction(this);
//                break;
//            case R.id.rlWifi:
//                break;
//            default:
//        }
//    }
}
