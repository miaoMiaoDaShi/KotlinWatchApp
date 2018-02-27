package cn.zcoder.xxp.user.ui.activity

import android.view.View
import cn.zcoder.xxp.base.ext.onClick
import cn.zcoder.xxp.base.ext.toast
import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.provider.arouter.RouterPath
import cn.zcoder.xxp.user.R
import com.alibaba.android.arouter.facade.annotation.Route

import kotlinx.android.synthetic.main.activity_login.*


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/24
 * Description :登录
 */
@Route(path = RouterPath.UserCenter.PATH_LOGIN)
class LoginActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }


    override fun bindListener() {
        super.bindListener()
        tvToSelect.onClick(mOnClickListener)
        tvForgetPwd.onClick(mOnClickListener)
        btnLogin.onClick(mOnClickListener)
        btnRegister.onClick(mOnClickListener)
    }


    override fun start() {
    }

    private val mOnClickListener = View.OnClickListener {
        when (it.id) {
            R.id.tvToSelect -> {
            } //SelectCountryActivity.startAction(this)
            R.id.tvForgetPwd ->
                RegForgetModifyActivity.startAction(this, RegForgetModifyActivity.PAGE_TYPE_FORGET_PWD)
            R.id.btnLogin -> login()
            R.id.btnRegister ->
                RegForgetModifyActivity.startAction(this, RegForgetModifyActivity.PAGE_TYPE_REGISTER)
        }
    }

    private fun login() {
        if (txtPhone.text.trim().isEmpty() or txtPwd.text.isEmpty()) {
            toast("任何一项不能为空~")
            // return
        }
        finish()
    }
}
