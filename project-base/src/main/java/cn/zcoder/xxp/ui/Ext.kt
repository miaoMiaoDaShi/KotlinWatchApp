package cn.zcoder.xxp.ui

import cn.zcoder.xxp.base.Configurator
import cn.zcoder.xxp.base.net.RetrofitClient
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.observers.DisposableObserver
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import timber.log.Timber
import java.io.IOException


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/27
 * Description :
 */

/**
 * 根据坐标获取位置name
 * @param lat
 * @param lng
 */
fun getLocationName(lat: Double, lng: Double, successBlock: () -> Unit, errorBlock: () -> Unit) {
    Observable.create(ObservableOnSubscribe<String> { observableEmitter ->
        val request = Request.Builder()
                .get()
                .url("http://api.map.baidu.com/cloudrgc/v1?location=" + lat + ","
                        + lng + "&ak=HcqD98UrwBSK3X7sI4Osa9uu6gyNjZ9K&geotable_id=" +
                        "184418" +
                        "&mcode=4C:BB:66:4A:42:C4:AD:F9:DD:43:7F:0C:72:DF:9F:CB:AB:E4:99:18;cn.zcoder.xxp.bnwatch")
                .build()
        val call = Configurator.okHttpClient.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                observableEmitter.onError(e)
                //onError(e)
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                Timber.i(response.body()!!.string())
                observableEmitter.onNext(response.toString())
            }
        })
    })
            .compose(RetrofitClient.SCHEDULERS_TRANSFORMER)
            .subscribeWith(object : DisposableObserver<String>() {
                override fun onNext(s: String) {
                    Timber.i(s)
                    successBlock.invoke()
                }

                override fun onError(e: Throwable) {
                    Timber.e(e)
                    errorBlock.invoke()
                }

                override fun onComplete() {

                }
            } as DisposableObserver<Any>)

}