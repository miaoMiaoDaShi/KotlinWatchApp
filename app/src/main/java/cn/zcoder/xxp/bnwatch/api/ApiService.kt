package cn.zcoder.xxp.bnwatch.api

import cn.zcoder.xxp.bnwatch.entity.SystemConfigInfo
import io.reactivex.Observable
import retrofit2.http.GET


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/27
 * Description :
 */

interface ApiService {
    /**
     * 获取系统配置
     */
    @GET("systemController/getSystemConfig")
    fun getSystemConfig(): Observable<SystemConfigInfo>
}