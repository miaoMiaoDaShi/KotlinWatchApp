package cn.zcoder.xxp.base.net

import android.text.TextUtils


import java.util.concurrent.TimeUnit

import cn.zcoder.xxp.base.Configurator
import com.google.common.io.Files.map
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/8
 * Description :
 */


object RetrofitClient {

    /**
     * 这里是关键
     *
     * @param disposable
     * @param <E>        你必须继承我的BaseDisposable
     * @param <T>        数据类型
     * @return
     * @see BaseDisposable
    </T></E> */
    fun <E : BaseDisposable<T>,T :BaseResponse> subscribe(disposable: BaseDisposable<T>): E {

        COMPOSITE_DISPOSABLE.add(disposable)
        disposable
                .observable
                .compose(SCHEDULERS_TRANSFORMER)
                .compose(ERROR_TRANSFORMER)
                .subscribeWith(disposable as BaseDisposable<Any>)

        return disposable as E
    }

    /**
     * 这个配合lambda饮用味更佳
     *
     * @param observable
     * @param onNext
     * @param onError
     * @param <E>
     * @param <T>
     * @return
    </T></E> */
    fun <E : Disposable, T : BaseResponse> subscribe(observable: Observable<T>,
                                                     onNext: Consumer<in T>,
                                                     onError: Consumer<in Throwable>): E {

        val disposable = observable
                .compose(SCHEDULERS_TRANSFORMER)
                .compose(ERROR_TRANSFORMER)
                .subscribe(onNext as Consumer<in Any>?, onError)

        COMPOSITE_DISPOSABLE.add(disposable)


        return disposable as E
    }


    /**
     * 抛出的异常转化成 自定义的异常
     */
    private class TransformToCustomException : Function<Throwable, Observable<*>> {

        @Throws(Exception::class)
        override fun apply(throwable: Throwable): Observable<*> {
            return Observable.error<Any>(ExceptionHandle.handleException(throwable))
        }
    }

    /**
     * 检测返回的数据是不是Ok的
     */
    private class HandleFun : Function<Any, Any> {
        @Throws(Exception::class)
        override fun apply(o: Any): Any {
            val response = o as BaseResponse
            if (!response.isOk) {
                //如果错误码和错误信息都是null,
                throw RuntimeException(if (TextUtils.isEmpty(response.status.toString() + "" + response.resmsg))
                    ""
                else
                    response.resmsg)
            }
            return o
        }
    }


    private val DEFAULT_TIMEOUT: Long = 30
    val HTTP_CLIENT_BUILDER: OkHttpClient.Builder = OkHttpClient.Builder()
            .addNetworkInterceptor(
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
    private val COMPOSITE_DISPOSABLE = CompositeDisposable()

    /**
     * 默认使用此处的OkhttpCLient
     */
    val RETROFIT_BUILDER: Retrofit.Builder = Retrofit.Builder()
            .client(if (Configurator.okHttpClient != null)
                Configurator.okHttpClient
            else
                HTTP_CLIENT_BUILDER.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(Configurator.apiHost)


    fun <T> getApiService(service: Class<T>): T {
        return RETROFIT_BUILDER.build().create(service)
    }


    /**
     * 错误相关
     *
     * @return
     */
    val ERROR_TRANSFORMER: ObservableTransformer<in Any, out Any>?
        get() =
            ObservableTransformer {
                it.map(HandleFun())
                        .onErrorResumeNext(TransformToCustomException())
            }

    /**
     * 线程的调度
     *
     * @return
     */
    val SCHEDULERS_TRANSFORMER: ObservableTransformer<in Any, out Any>?
        get() = ObservableTransformer {
            it.subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }

}
