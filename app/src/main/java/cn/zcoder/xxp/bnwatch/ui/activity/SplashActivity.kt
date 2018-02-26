package cn.zcoder.xxp.bnwatch.ui.activity

import android.os.Bundle
import android.os.Handler
import cn.zcoder.xxp.base.ui.activity.BaseMvpActivity
import cn.zcoder.xxp.bnwatch.R
import cn.zcoder.xxp.bnwatch.contract.HomeContract
import cn.zcoder.xxp.bnwatch.presenter.HomePresenter
import com.alibaba.android.arouter.launcher.ARouter
import org.jetbrains.anko.startActivity


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/24
 * Description : 启动页面
 */


class SplashActivity : BaseMvpActivity<HomeContract.View, HomeContract.Presenter>(), HomeContract.View {
    override fun showLoading() {

    }

    override fun dismissLoading() {

    }

    override fun createPresenter(): HomeContract.Presenter {
        return HomePresenter()
    }

    override fun showLocationNameSuccess(lat: String, lng: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLocationNameError(e: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoadHomeDataSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoadHomeDataError(e: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSystemConfigSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSystemConfigError(e: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun start() {
        Handler().postDelayed({ startActivity<MainActivity>() }, 1000)

    }


}
