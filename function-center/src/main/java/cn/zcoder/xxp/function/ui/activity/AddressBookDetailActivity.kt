package cn.zcoder.xxp.function.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar


import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.ui.widget.ToolBar
import kotlinx.android.synthetic.main.activity_address_book_detail.*

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/24
 * Description :通讯录详情
 */

class AddressBookDetailActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_address_book_detail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("详细资料")
                .setOnLeftImageListener {
                    finish()
                }
    }

    companion object {
        //    @BindView(R.id.ivPortrait)
        //    ImageView ivPortrait;
        //    @BindView(R.id.tvRelation)
        //    TextView tvRelation;
        //    @BindView(R.id.tvType)
        //    TextView tvType;

    }

    //    @OnClick({R.id.rlModifyPortrait, R.id.rlRelation, R.id.btnDel})
    //    public void onViewClicked(View view) {
    //        switch (view.getId()) {
    //            case R.id.rlModifyPortrait:
    //                break;
    //            case R.id.rlRelation:
    //                EditRelationActivity.startAction(this,false);
    //                break;
    //            case R.id.btnDel:
    //                break;
    //            default:
    //        }
    //    }
}
