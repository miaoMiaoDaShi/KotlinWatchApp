package cn.zcoder.xxp.base.ui.activity

import android.os.Bundle
import android.support.annotation.LayoutRes
import com.zhy.autolayout.AutoLayoutActivity


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/24
 * Description :
 */

abstract class BaseActivity : AutoLayoutActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initData()
        initView(savedInstanceState)
        bindListener()
        start()
    }

    protected open fun initData() {
    }

    protected open fun start() {

    }

    protected open fun bindListener() {
    }

    /**
     * 加载布局
     */
    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected open fun initView(savedInstanceState: Bundle?) {
    }
}