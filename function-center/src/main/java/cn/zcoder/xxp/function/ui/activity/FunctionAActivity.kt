package cn.zcoder.xxp.function.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView


import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.ui.widget.ToolBar
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :通讯录
 */

class FunctionAActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_fun_a
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("通讯录")
                .setOnLeftImageListener({finish()})
    }

    companion object {
        //    @BindView(R.id.ivIcon)
        //    CircleImageView ivIcon;
        //    @BindView(R.id.tvName)
        //    TextView tvName;
        //    @BindView(R.id.tvNum)
        //    TextView tvNum;
        //    @BindView(R.id.flContent)
        //    FrameLayout flContent;

        fun startAction(context: Context) {
            context.startActivity(Intent(context, FunctionAActivity::class.java))
        }
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
