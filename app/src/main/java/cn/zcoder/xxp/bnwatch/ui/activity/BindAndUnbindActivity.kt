package cn.zcoder.xxp.bnwatch.ui.activity

import android.os.Bundle
import android.view.View
import cn.zcoder.xxp.base.ext.onClick

import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.bnwatch.R
import cn.zcoder.xxp.ui.ToolBar
import cn.zcoder.xxp.ui.WarnDialog
import kotlinx.android.synthetic.main.activity_bind_and_unbind.*


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/24
 * Description : 绑定与解绑
 */

class BindAndUnbindActivity : BaseActivity(), View.OnClickListener {


    override fun getLayoutId(): Int {
        return R.layout.activity_bind_and_unbind
    }

    override fun bindListener() {
        super.bindListener()
        btnCommit.onClick(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle(getString(R.string.bind_unbind))
                .setOnLeftImageListener({ finish() })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCommit -> {
                val dialog = WarnDialog.show(supportFragmentManager, "警告", "你确定要解除绑定?")
                dialog.setOnClickListener(object : WarnDialog.OnClickListener {
                    override fun onConfirm() {

                    }

                    override fun onCancel() {

                    }
                })
            }
            else -> {
            }
        }

    }


}
