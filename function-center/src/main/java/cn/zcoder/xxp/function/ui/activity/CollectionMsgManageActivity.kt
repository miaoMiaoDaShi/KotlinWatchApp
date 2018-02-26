package cn.zcoder.xxp.function.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle

import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.ui.widget.ToolBar

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :佩戴检测
 */

class CollectionMsgManageActivity : BaseActivity() {


    public override fun getLayoutId(): Int {
        return R.layout.activity_collection_msg_manage
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("代收短信管理")
                .setOnLeftImageListener({ finish() })
                .setOnRightTextListener("完成", { editDone() })
    }

    /**
     * 编辑完成
     */
    private fun editDone() {

    }

    companion object {

        fun startAction(context: Context) {
            context.startActivity(Intent(context, CollectionMsgManageActivity::class.java))
        }
    }
}
