package cn.zcoder.xxp.bnwatch.ui.activity

import android.os.Bundle
import android.os.Handler
import cn.zcoder.xxp.base.ui.activity.BaseMvpActivity
import cn.zcoder.xxp.bnwatch.R
import cn.zcoder.xxp.bnwatch.contract.HomeContract
import cn.zcoder.xxp.bnwatch.contract.SplashContract
import cn.zcoder.xxp.bnwatch.presenter.HomePresenter
import cn.zcoder.xxp.bnwatch.presenter.SplashPresenter
import com.alibaba.android.arouter.launcher.ARouter
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/24
 * Description : 启动页面
 */


class SplashActivity : BaseMvpActivity<SplashContract.View, SplashContract.Presenter>(), SplashContract.View {
    override fun showLoading() {

    }

    override fun dismissLoading() {

    }

    override fun createPresenter(): SplashContract.Presenter {
        return SplashPresenter()
    }


    override fun showSystemConfigSuccess() {
        Handler().postDelayed({
            finish()
            startActivity<MainActivity>()
        }, 1000)
    }

    override fun showSystemConfigError(e: String) {
        toast(e)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun start() {
        getPresenter().loadSystemConfig()
    }


}
