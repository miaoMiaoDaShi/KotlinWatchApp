package cn.zcoder.xxp.bnwatch.ui.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import cn.zcoder.xxp.base.ext.onClick


import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.bnwatch.R
import cn.zcoder.xxp.ui.ToolBar
import kotlinx.android.synthetic.main.activity_watch_phone.*

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/24
 * Description : 手表号码
 */

class WatchNumActivity : BaseActivity(), TextWatcher, View.OnClickListener {


    override fun getLayoutId(): Int {
        return R.layout.activity_watch_phone
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle(getString(R.string.watch_phone))
                .setOnLeftImageListener({ finish() })

        txtNum.addTextChangedListener(this)
    }


    override fun bindListener() {
        super.bindListener()
        btnCommit.onClick(this)
        ivClean.onClick(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCommit -> {
            }
            R.id.ivClean -> txtNum.setText("")
        }

    }


    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

    }

    override fun afterTextChanged(s: Editable) {
        ivClean!!.visibility = if (s.length != 0) View.VISIBLE else View.GONE
    }


}
