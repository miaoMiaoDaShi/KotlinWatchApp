package cn.zcoder.xxp.base.ext

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