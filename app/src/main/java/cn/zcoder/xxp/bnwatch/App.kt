package cn.zcoder.xxp.bnwatch

import android.support.multidex.MultiDexApplication
import cn.zcoder.xxp.base.Configurator
import cn.zcoder.xxp.base.common.Preference
import com.alibaba.android.arouter.launcher.ARouter
import com.baidu.mapapi.SDKInitializer


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/26
 * Description :
 */

class App : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        Configurator.withApplicationContext(this)
                .withApiHost("https://www.baidu.com/")
                .withSPFileName("")
        ARouter.init(this)
        SDKInitializer.initialize(this)

    }
}