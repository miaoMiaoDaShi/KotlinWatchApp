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
 * Description :
 */

class WeekdaySelectActivity : BaseActivity() {
    private val mWeekDays by lazy {
        resources.getStringArray(R.array.weekdays).asList()
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
                .setTitle("重复")
                .setOnLeftImageListener { finish() }

        mRv.layoutManager = LinearLayoutManager(this)

        mRv.adapter = object : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_for_light, mWeekDays) {
            override fun convert(helper: BaseViewHolder?, item: String?) {
                helper?.setText(R.id.tvTitle, item)
            }

        }
    }

    override fun start() {
        super.start()

    }
}