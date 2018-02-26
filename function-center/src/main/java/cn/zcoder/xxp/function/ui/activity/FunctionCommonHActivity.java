package cn.zcoder.xxp.function.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import cn.zcoder.xxp.base.ui.activity.BaseActivity;
import cn.zcoder.xxp.function.R;
import cn.zcoder.xxp.ui.widget.ToolBar;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :语音提示
 */

public class FunctionCommonHActivity extends BaseActivity {

    ToolBar toolBar;
    Switch switchViewAsr;
    Switch switchViewBroadcast;

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, FunctionCommonHActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fun_common_h;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolBar.setTitle("语音提示")
                .setOnLeftImageListener(new ToolBar.OnLeftImageListener() {
                    @Override
                    public void onClick() {
                        finish();
                    }
                });
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
