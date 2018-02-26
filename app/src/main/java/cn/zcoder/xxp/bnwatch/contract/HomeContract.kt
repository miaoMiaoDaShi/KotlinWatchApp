package cn.zcoder.xxp.bnwatch.contract

import cn.zcoder.xxp.base.mvp.presenter.RxPresenter
import cn.zcoder.xxp.base.mvp.view.MvpView

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/3
 * Description :主页信息
 */


interface HomeContract {
    interface View : MvpView {
        /**
         * 根据金纬度得到name(掉的是百度的数据接口)
         */
        fun showLocationNameSuccess(lat: String, lng: String)

        fun showLocationNameError(e: String)

        /**
         * 加载的是服务器端的数据
         */
        fun showLoadHomeDataSuccess()

        fun showLoadHomeDataError(e: String)

        /**
         * 启动页的数据
         */
        fun showSystemConfigSuccess()
        fun showSystemConfigError(e: String)


    }

    abstract class Presenter : RxPresenter<View>()

}
