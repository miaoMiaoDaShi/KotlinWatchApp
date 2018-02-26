package cn.zcoder.xxp.function.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;


import cn.zcoder.xxp.base.ui.activity.BaseActivity;
import cn.zcoder.xxp.function.R;
import cn.zcoder.xxp.ui.widget.ToolBar;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :通讯录
 */

public class FunctionAActivity extends BaseActivity {

    ToolBar toolBar;
//    @BindView(R.id.ivIcon)
//    CircleImageView ivIcon;
//    @BindView(R.id.tvName)
//    TextView tvName;
//    @BindView(R.id.tvNum)
//    TextView tvNum;
//    @BindView(R.id.flContent)
//    FrameLayout flContent;

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, FunctionAActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fun_a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolBar.setTitle("通讯录")
                .setOnLeftImageListener(new ToolBar.OnLeftImageListener() {
                    @Override
                    public void onClick() {
                        finish();
                    }
                });
    }

//    @OnClick({R.id.btnEdit, R.id.btnAddFriends})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.btnEdit:
//                MineDataActivity.startAction(this);
//                break;
//            case R.id.btnAddFriends:
//                EditRelationActivity.startAction(this,true);
//                break;
//            default:
//        }
//    }
}
