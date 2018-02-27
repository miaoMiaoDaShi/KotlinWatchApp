package cn.zcoder.xxp.ui

import android.app.Application
import cn.zcoder.xxp.base.Configurator
import com.alibaba.android.arouter.launcher.ARouter
import com.baidu.mapapi.SDKInitializer


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/27
 * Description :
 */

class BaseApplication:Application()  {
    override fun onCreate() {
        super.onCreate()
        Configurator.withApplicationContext(this)
                .withApiHost("http://api.szycwc.com/GXZNG_Server/")
                .withAppFolder("watch")
                .withSPFileName("")
        ARouter.openLog()    // 打印日志
        ARouter.openDebug()
        ARouter.init(this)
        SDKInitializer.initialize(this)
    }
}