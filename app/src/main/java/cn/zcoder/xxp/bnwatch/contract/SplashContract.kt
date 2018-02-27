package cn.zcoder.xxp.bnwatch.contract

import cn.zcoder.xxp.base.mvp.presenter.RxPresenter
import cn.zcoder.xxp.base.mvp.view.MvpView


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/27
 * Description :
 */

interface SplashContract {
    interface View:MvpView{
        /**
         * 启动页的数据
         */
        fun showSystemConfigSuccess()
        fun showSystemConfigError(e: String)
    }

    abstract class Presenter : RxPresenter<SplashContract.View>(){
        abstract fun loadSystemConfig()
    }
}