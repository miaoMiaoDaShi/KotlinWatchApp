package cn.zcoder.xxp.function.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import cn.zcoder.xxp.base.ui.activity.BaseActivity;
import cn.zcoder.xxp.function.R;
import cn.zcoder.xxp.ui.widget.ToolBar;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :手表话费
 */

public class FunctionCommonAActivity extends BaseActivity {
    ToolBar toolBar;
    public static void startAction(Context context) {
        context.startActivity(new Intent(context, FunctionCommonAActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fun_common_a;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolBar.setTitle("手表话费")
                .setOnLeftImageListener(new ToolBar.OnLeftImageListener() {
                    @Override
                    public void onClick() {
                        finish();
                    }
                });
    }
}
