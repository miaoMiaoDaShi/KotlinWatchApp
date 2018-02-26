package cn.zcoder.xxp.base.ext

import android.content.Context
import android.support.v4.app.Fragment
import android.widget.Toast
import cn.zcoder.xxp.base.common.Constant


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/24
 * Description : toast扩展文件
 */
fun Context.toast(content: String) {
    Constant.showToast?.apply {
        setText(content)
        show()

    } ?: run {
        Toast.makeText(this.applicationContext, content, Toast.LENGTH_SHORT).apply {
            Constant.showToast = this
        }.show()
    }
}

fun Context.toast(stringId: Int) {
    toast(getString(stringId))
}


