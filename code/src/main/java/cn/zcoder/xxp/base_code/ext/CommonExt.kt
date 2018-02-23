package cn.zcoder.xxp.base_code.ext

import android.view.View


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/23
 * Description :
 */

/**
 * 点击事件扩展方法
 */
fun View.onClick(method:()->Unit):View{
    setOnClickListener { method }
    return this
}

/**
 * 点击事件扩展方法
 */
fun View.onClick(listener:View.OnClickListener):View{
    setOnClickListener (listener)
    return this
}