package cn.zcoder.xxp.base.net

import cn.zcoder.xxp.base.mvp.view.MvpView
import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/10
 * Description :
 */

abstract class BaseDisposable<T>(val observable: Observable<T>,val view: MvpView) : DisposableObserver<T>() {

    override fun onError(e: Throwable) {
        if (e is ExceptionHandle.ResponseThrowable) {
            onError(e)
        } else {
            onError(ExceptionHandle.ResponseThrowable(e, ExceptionHandle.ERROR_CODE.UNKNOWN))
        }

        view.dismissLoading()
    }

    override open fun onStart() {
        super.onStart()
        view.showLoading()

    }

    override fun onComplete() {
       view.dismissLoading()
    }



    abstract fun onError(e: ExceptionHandle.ResponseThrowable)

}
