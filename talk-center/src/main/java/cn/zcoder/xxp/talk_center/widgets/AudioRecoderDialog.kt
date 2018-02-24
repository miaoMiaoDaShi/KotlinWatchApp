package cn.zcoder.xxp.talk_center.widgets

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import cn.zcoder.xxp.talk_center.R
import cn.zcoder.xxp.ui.widget.dialog.BasePopupWindow


/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/2/11
 * Description :
 */

class AudioRecoderDialog(context: Context) : BasePopupWindow(context) {

    private val imageView: ImageView
    private val textView: TextView

    init {
        val contentView = LayoutInflater.from(context).inflate(R.layout.layout_recoder_dialog, null)
        imageView = contentView.findViewById<View>(android.R.id.progress) as ImageView
        textView = contentView.findViewById<View>(android.R.id.text1) as TextView
        setContentView(contentView)
    }

    fun setLevel(level: Int) {
        val drawable = imageView.drawable
        drawable.level = 3000 + 6000 * level / 100
    }

    fun setTime(time: Long) {
        // textView.setText(ProgressTextUtils.getProgressText(time));
    }
}
