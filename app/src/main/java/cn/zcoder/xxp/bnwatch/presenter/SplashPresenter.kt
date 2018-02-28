package cn.zcoder.xxp.bnwatch.presenter

import cn.zcoder.xxp.base.common.Preference
import cn.zcoder.xxp.base.net.ExceptionHandle
import cn.zcoder.xxp.base.net.RetrofitClient
import cn.zcoder.xxp.bnwatch.api.ApiService
import cn.zcoder.xxp.bnwatch.contract.SplashContract
import cn.zcoder.xxp.bnwatch.entity.SystemConfigInfo
import com.google.gson.Gson


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/26
 * Description :
 */
class SplashPresenter : SplashContract.Presenter() {
    var mSystemConfiginfo by Preference("systemConfig", "")
    override fun loadSystemConfig() {
        addSubscribe(RetrofitClient.getApiService(ApiService::class.java).getSystemConfig()
                .compose(RetrofitClient.defaultTransformer(getView()))
                .subscribe(
                        { t ->
                            getView().showSystemConfigSuccess()
                            mSystemConfiginfo = Gson().toJson(t)
                        },
                        { e -> getView().showSystemConfigError(ExceptionHandle.handleException(e).errorMessage) }))
    }
}