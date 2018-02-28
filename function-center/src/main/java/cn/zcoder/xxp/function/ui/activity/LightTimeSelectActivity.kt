package cn.zcoder.xxp.function.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.ui.ToolBar
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/28
 * Description : 亮屏时间
 */

class LightTimeSelectActivity : BaseActivity() {
    private val mWeekDays by lazy {
        listOf(5, 10, 15, 20, 30, 60)
    }
    private val mRv by lazy {
        findViewById<RecyclerView>(R.id.mRv)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_recycler_view
    }

    override fun initData() {
        super.initData()

    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("亮屏时间")
                .setOnLeftImageListener { finish() }

        mRv.layoutManager = LinearLayoutManager(this)

        mRv.adapter = object : BaseQuickAdapter<Int, BaseViewHolder>(R.layout.item_for_light, mWeekDays) {
            override fun convert(helper: BaseViewHolder?, item: Int?) {
                helper?.setText(R.id.tvTitle, "${item}秒")
            }

        }
    }

    override fun start() {
        super.start()

    }
}