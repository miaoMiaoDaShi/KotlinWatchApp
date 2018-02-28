package cn.zcoder.xxp.message.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView


import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.message.R
import cn.zcoder.xxp.ui.ToolBar


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/24
 * Description :消息详情
 */

class MsgDetailActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_msg_detail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar).setTitle("信息详情")
                .setOnLeftImageListener({ finish() })
                .setOnRightTextListener(getString(R.string.del), { delMsg() })
    }

    /**
     * 删除消息
     */
    private fun delMsg() {

    }

}

