package cn.zcoder.xxp.user.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cn.zcoder.xxp.provider.arouter.RouterPath
import com.alibaba.android.arouter.facade.annotation.Route


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/27
 * Description : 修改密码中转
 */
@Route(path = RouterPath.UserCenter.PATH_MOD_PWD)
class ModPwdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        RegForgetModifyActivity.startAction(this, RegForgetModifyActivity.PAGE_TYPE_MODIFY_PWD)
        finish()
    }
}