package cn.zcoder.xxp.base.ext

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/26
 * Description :
 */

/**
 * 主要用于将数据实体转化为有序的map
 */
fun parseData(data: Any): Map<String, String>? {
    val gson = Gson()
    val json = gson.toJson(data)
    return gson.fromJson<Map<String, String>>(json, object : TypeToken<TreeMap<String, String>>() {

    }.type)
}

fun getRealFilePath(context: Context, uri: Uri?): String? {
    if (null == uri) {
        return null
    }
    val scheme = uri.scheme
    var data: String? = null
    if (scheme == null) {
        data = uri.path
    } else if (ContentResolver.SCHEME_FILE == scheme) {
        data = uri.path
    } else if (ContentResolver.SCHEME_CONTENT == scheme) {
        val cursor = context.contentResolver.query(uri, arrayOf(MediaStore.Images.ImageColumns.DATA), null, null, null)
        if (null != cursor) {
            if (cursor.moveToFirst()) {
                val index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
                if (index > -1) {
                    data = cursor.getString(index)
                }
            }
            cursor.close()
        }
    }
    return data
}