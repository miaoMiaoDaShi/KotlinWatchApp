package cn.zcoder.xxp.function.ui.activity;

import android.content.Context;
import android.content.Intent;

import cn.zcoder.xxp.base.ui.activity.BaseActivity;
import cn.zcoder.xxp.function.R;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/8
 * Description :
 */


public class SoundAndSnakeActivity extends BaseActivity {
    public static void startAction(Context context) {
        Intent intent = new Intent(context, SoundAndSnakeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sound_and_snake;
    }
}
