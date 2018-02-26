package cn.zcoder.xxp.function.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Switch;

import cn.zcoder.xxp.base.ui.activity.BaseActivity;
import cn.zcoder.xxp.function.R;
import cn.zcoder.xxp.ui.widget.ToolBar;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :通讯录
 */

public class FunctionCommonDActivity extends BaseActivity {

    ToolBar toolBar;
    Switch switchView;

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, FunctionCommonDActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fun_common_d;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolBar.setTitle("计步")
                .setOnLeftImageListener(new ToolBar.OnLeftImageListener() {
                    @Override
                    public void onClick() {
                        finish();
                    }
                });
    }
}
