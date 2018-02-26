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
 * Description :佩戴检测
 */

public class CollectionMsgManageActivity extends BaseActivity {

    ToolBar toolBar;

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, CollectionMsgManageActivity.class));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_collection_msg_manage;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolBar.setTitle("代收短信管理")
                .setOnLeftImageListener(new ToolBar.OnLeftImageListener() {
                    @Override
                    public void onClick() {
                        finish();
                    }
                })
                .setOnRightTextListener("完成", new ToolBar.OnRightTextListener() {
                    @Override
                    public void onClick() {
                        editDone();
                    }
                });
    }

    /**
     * 编辑完成
     */
    private void editDone() {

    }
}
