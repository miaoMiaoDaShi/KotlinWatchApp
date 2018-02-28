package cn.zcoder.xxp.message.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.RelativeLayout
import cn.zcoder.xxp.base.ext.onClick
import cn.zcoder.xxp.base.ext.visible
import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.message.R
import cn.zcoder.xxp.message.adapter.MsgAdapter
import cn.zcoder.xxp.message.entity.MsgInfo
import cn.zcoder.xxp.provider.arouter.RouterPath
import cn.zcoder.xxp.ui.ToolBar
import com.alibaba.android.arouter.facade.annotation.Route

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import kotlinx.android.synthetic.main.activity_msg.*
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity


import java.util.ArrayList


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/24
 * Description : 消息中心
 */
@Route(path = RouterPath.MessageCenter.PATH_MSG)
class MsgActivity : BaseActivity(), BaseQuickAdapter.OnItemLongClickListener,
        CompoundButton.OnCheckedChangeListener, BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemChildClickListener {


    private val mMsgInfos: MutableList<MsgInfo> by lazy {
        ArrayList<MsgInfo>()
    }
    /**
     * 编辑状态
     */
    private var mIsEdit = false

    override fun getLayoutId(): Int {
        return R.layout.activity_msg
    }


    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar).setTitle("消息中心")
                .setOnLeftImageListener({ finish() })
                .setOnRightTextListener(getString(R.string.edit), { if (mIsEdit) editDone() else setEditStatus(true) })
                .showRightText(true)

        findViewById<CheckBox>(R.id.checkbox).setOnCheckedChangeListener(this)
    }

    override fun start() {
        super.start()
        loadData()
    }

    /**
     * 加载数据
     */
    private fun loadData() {
        for (i in 0..9) {
            val info = MsgInfo()
            info.setDes("打法是否 发地方撒旦撒地方")
            info.setStatus((Math.random() * 2).toInt())
            info.setTitle("消息测试")
            info.setType(i % 2)
            mMsgInfos.add(info)
        }
        val adapter = object : MsgAdapter(mMsgInfos) {
            override fun convert(helper: BaseViewHolder, item: MsgInfo) {
                helper.setText(R.id.tvTitle, item.title)
                        .setText(R.id.tvDes, item.des)
                        .setText(R.id.tvTime, "下午 13:00")
                        .setVisible(R.id.checkbox, mIsEdit)
                        .setChecked(R.id.checkbox, item.isChecked)
                        .setVisible(R.id.ivMsgRead, item.status === 0)
                        .addOnClickListener(R.id.checkbox)
                when (helper.itemViewType) {
                    0 -> {
                    }
                    1 -> {
                    }
                }
            }
        }
        adapter.onItemLongClickListener = this
        adapter.onItemClickListener = this
        adapter.onItemChildClickListener = this
        mRvMsg.layoutManager = LinearLayoutManager(applicationContext)
        mRvMsg.adapter = adapter
    }

    override fun bindListener() {
        super.bindListener()
        findViewById<Button>(R.id.btnDel).onClick {

        }
    }

    /**
     * 点击完成
     */
    private fun editDone() {
        setEditStatus(false)
    }

    private fun setEditStatus(isEdit: Boolean) {
        mIsEdit = isEdit
        findViewById<ToolBar>(R.id.mToolBar).setRightText(if (isEdit) "完成" else "编辑")
        findViewById<RelativeLayout>(R.id.rlBottom).visible(isEdit)
        mRvMsg.adapter.notifyDataSetChanged()
    }

    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        if (view is CheckBox) {
            mMsgInfos[position].isChecked = view.isChecked
        }

    }

    override fun onItemLongClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int): Boolean {
        setEditStatus(true)
        return true
    }


    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        for (msgInfo in mMsgInfos) {
            msgInfo.isChecked = isChecked
        }
        mRvMsg.adapter.notifyDataSetChanged()
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        if (mIsEdit) {
            view.find<CheckBox>(R.id.checkbox).toggle()
            mMsgInfos[position].isChecked = view.find<CheckBox>(R.id.checkbox).isChecked
            return
        }
        startActivity<MsgDetailActivity>()
    }

    override fun onBackPressed() {
        if (mIsEdit) setEditStatus(false) else super.onBackPressed()
    }
}
