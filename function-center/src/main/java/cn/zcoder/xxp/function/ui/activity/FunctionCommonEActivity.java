package cn.zcoder.xxp.function.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;

import java.util.Date;

import cn.zcoder.xxp.base.ui.activity.BaseActivity;
import cn.zcoder.xxp.function.R;
import cn.zcoder.xxp.ui.widget.ToolBar;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :定时开关机
 */

public class FunctionCommonEActivity extends BaseActivity {

    ToolBar toolBar;
    Switch switchView;
    TextView tvNo;
    TextView tvOff;
    private TimePickerView mTimePickerView;
    /**
     * 当前点击的View
     */
    private View mCurrentClickView;

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, FunctionCommonEActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fun_common_e;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolBar.setTitle("定时开关机")
                .setOnLeftImageListener(new ToolBar.OnLeftImageListener() {
                    @Override
                    public void onClick() {
                        finish();
                    }
                });

        initPickView();
    }

    private void initPickView() {
        mTimePickerView = new TimePickerView
                .Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
//                switch (mCurrentClickView.getId()) {
//                    case R.id.tvNo:
//                        break;
//                    case R.id.tvOff:
//                        break;
//                    default:
//                }

            }
        })
                .gravity(Gravity.CENTER)
                .setContentSize(23)
                .setLabel("", "", "", "", "", "")
                .setType(new boolean[]{false, false, false, true, true, false})
                .build();
    }

//    @OnClick({R.id.btnCancel, R.id.btnConfirm, R.id.tvNo, R.id.tvOff})
//    public void onViewClicked(View view) {
//        mCurrentClickView = view;
//        switch (view.getId()) {
//            case R.id.btnCancel:
//                break;
//            case R.id.btnConfirm:
//                break;
//            case R.id.tvNo:
//            case R.id.tvOff:
//                mTimePickerView.show();
//                break;
//            default:
//        }
//    }

}
