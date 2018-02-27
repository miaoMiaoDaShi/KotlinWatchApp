package cn.zcoder.xxp.user.ui.activity

import android.os.Bundle
import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.provider.arouter.RouterPath
import cn.zcoder.xxp.ui.ToolBar
import cn.zcoder.xxp.user.R
import com.alibaba.android.arouter.facade.annotation.Route


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/24
 * Description :个人资料
 */
@Route(path = RouterPath.UserCenter.PATH_DETAIL)
class MineDataActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_mine_data

    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("宝贝资料")
                .setOnLeftImageListener({ finish() })
    }

}
