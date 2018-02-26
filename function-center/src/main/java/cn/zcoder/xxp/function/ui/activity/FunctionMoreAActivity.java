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
 * Description :手表设置
 */

public class FunctionMoreAActivity extends BaseActivity {

    ToolBar toolBar;
    TextView tvLightTime;
    Switch switchView;

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, FunctionMoreAActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fun_more_a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolBar.setTitle("手表设置")
                .setOnLeftImageListener(new ToolBar.OnLeftImageListener() {
                    @Override
                    public void onClick() {
                        finish();
                    }
                });
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
