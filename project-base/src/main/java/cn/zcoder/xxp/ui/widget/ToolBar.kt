package cn.zcoder.xxp.ui.widget

import android.content.Context
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

import cn.zcoder.xxp.ui.R


/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/7/5
 * Description : 标题栏
 */


class ToolBar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : RelativeLayout(context, attrs, defStyleAttr) {
    private var ivTopBarLeft: ImageView? = null
    private var tvTopBarTitle: TextView? = null
    private var tvTopBarRight: TextView? = null
    private var ivTopBarRight: ImageView? = null

    private fun initView() {
        ivTopBarLeft = findViewById(R.id.ivTopBarLeft)
        tvTopBarTitle = findViewById(R.id.tvTopBarTitle)
        tvTopBarRight = findViewById(R.id.tvTopBarRight)
        ivTopBarRight = findViewById(R.id.ivTopBarRight)
    }


    override fun onFinishInflate() {
        super.onFinishInflate()
        initView()
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    fun setTitle(title: String): ToolBar {
        tvTopBarTitle!!.text = title
        return this
    }

    /**
     * 设置左边的icon
     *
     * @param id
     * @return
     */
    fun setLefticon(@DrawableRes id: Int): ToolBar {
        ivTopBarLeft!!.setImageResource(id)
        return this
    }

    /**
     * 设置右边的图标
     *
     * @param id
     * @return
     */
    fun setRighticon(@DrawableRes id: Int): ToolBar {
        ivTopBarRight!!.setImageResource(id)
        return this
    }

    /**
     * 设置右边显示的文字
     *
     * @param title
     * @return
     */
    fun setRightText(title: String): ToolBar {
        tvTopBarRight!!.text = title
        return this
    }

    /**
     * 是否显示右边的文字
     *
     * @param isvisible
     * @return
     */
    fun showRightText(isvisible: Boolean): ToolBar {
        tvTopBarRight!!.visibility = if (isvisible) View.VISIBLE else View.GONE
        return this
    }

    /**
     * 是否显示右边的icon
     *
     * @param isvisible
     * @return
     */
    fun showRightImage(isvisible: Boolean): ToolBar {
        ivTopBarRight!!.visibility = if (isvisible) View.VISIBLE else View.GONE
        return this
    }

    /**
     * 是否显示左边的icon
     *
     * @param isvisible
     * @return
     */
    fun showLeftImage(isvisible: Boolean): ToolBar {
        ivTopBarLeft!!.visibility = if (isvisible) View.VISIBLE else View.GONE
        return this
    }

    fun setOnLeftImageListener(leftImageListener: OnLeftImageListener): ToolBar {
        ivTopBarLeft!!.setOnClickListener { leftImageListener.onClick() }
        return this
    }

    fun setOnRightTextListener(text: String, rightTextListener: OnRightTextListener): ToolBar {
        tvTopBarRight!!.visibility = View.VISIBLE
        tvTopBarRight!!.text = text
        tvTopBarRight!!.setOnClickListener { rightTextListener.onClick() }
        return this
    }

    fun setOnRightImageListener(rightImageListener: OnRightImageListener): ToolBar {
        ivTopBarRight!!.visibility = View.VISIBLE
        ivTopBarRight!!.setOnClickListener { rightImageListener.onClick() }
        return this
    }

    interface OnLeftImageListener {
        fun onClick()
    }

    interface OnRightTextListener {
        fun onClick()
    }

    interface OnRightImageListener {
        fun onClick()
    }

}
