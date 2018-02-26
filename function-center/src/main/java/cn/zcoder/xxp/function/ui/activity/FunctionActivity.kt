package cn.zcoder.xxp.function.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.widget.TextView

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder


import java.util.ArrayList


import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.provider.arouter.RouterPath
import cn.zcoder.xxp.ui.widget.ToolBar
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_function.*
import org.jetbrains.anko.startActivity

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :功能模块页面
 */
@Route(path = RouterPath.FunctionCenter.PATH_FUNCTION)
class FunctionActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar).setTitle(getString(R.string.function))
                .setOnLeftImageListener({ finish() })
        setUpFunction()
    }

    private fun setUpFunction() {
        mRvFunction.layoutManager = GridLayoutManager(applicationContext, 4)

        val functionTitles = resources.getStringArray(R.array.function_module)
        val functionIcons = intArrayOf(R.drawable.function_module_a, R.drawable.function_module_b, R.drawable.function_module_c, R.drawable.function_module_d)

        val functions = ArrayList<SparseArray<String>>()
        for (i in 0..3) {
            val sparseArray = SparseArray<String>(1)
            sparseArray.put(functionIcons[i], functionTitles[i])
            functions.add(sparseArray)
        }
        val adapter = FunctionAdapter(functions)
        adapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            when (position) {
                0 ->
                    //通讯录
                    startActivity<FunctionAActivity>()
                1 ->
                    //上课守护
                    startActivity<FunctionBActivity>()
                2 ->
                    //上课禁用
                    startActivity<FunctionCActivity>()
                3 ->
                    //佩戴检测
                    startActivity<FunctionDActivity>()
            }
        }
        mRvFunction.adapter = adapter
        setUpFunctionMore()
        setUpFunctionCommon()
    }

    private fun setUpFunctionMore() {
        mRvFunctionMore.layoutManager = GridLayoutManager(applicationContext, 4)
        val functionTitles = resources.getStringArray(R.array.function_module_more)
        val functionIcons = intArrayOf(R.drawable.function_module_more_a, R.drawable.function_module_more_b, R.drawable.function_module_more_c, R.drawable.function_module_more_d)


        val functions = ArrayList<SparseArray<String>>()
        for (i in 0..3) {
            val sparseArray = SparseArray<String>(1)
            sparseArray.put(functionIcons[i], functionTitles[i])
            functions.add(sparseArray)
        }
        val adapter = FunctionAdapter(functions)
        adapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            when (position) {
                0 ->
                    //手表设置
                    startActivity<FunctionMoreAActivity>()
                1 ->
                    //拒绝陌生人来电
                    startActivity<FunctionMoreCActivity>()
                2 ->
                    //体感接听
                    startActivity<FunctionMoreCActivity>()
                3 ->
                    //佩戴检测
                    startActivity<FunctionMoreDActivity>()
            }
        }
        mRvFunctionMore.adapter = adapter

    }

    private fun setUpFunctionCommon() {
        mRvFunctionCommon.layoutManager = GridLayoutManager(applicationContext, 4)
        val functionTitles = resources.getStringArray(R.array.function_module_common)
        val functionIcons = intArrayOf(R.drawable.function_module_common_a, R.drawable.function_module_common_b, R.drawable.function_module_common_c, R.drawable.function_module_common_d, R.drawable.function_module_common_e, R.drawable.function_module_common_f, R.drawable.function_module_common_g, R.drawable.function_module_common_h)

        val functions = ArrayList<SparseArray<String>>()
        for (i in 0..7) {
            val sparseArray = SparseArray<String>(1)
            sparseArray.put(functionIcons[i], functionTitles[i])
            functions.add(sparseArray)
        }
        val adapter = FunctionAdapter(functions)
        adapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            when (position) {
                0 ->
                    //手表话费
                    startActivity<FunctionCommonAActivity>()
                1 ->
                    //代收短信
                    startActivity<FunctionCommonBActivity>()
                2 ->
                    //通话位置
                    startActivity<FunctionCommonCActivity>()
                3 ->
                    //计步
                    startActivity<FunctionCommonDActivity>()
                4 ->
                    //定时开关机
                    startActivity<FunctionCommonEActivity>()
                5 ->
                    //自动连接
                    startActivity<FunctionCommonFActivity>()
                6 ->
                    //预留电量
                    startActivity<FunctionCommonGActivity>()
                7 ->
                    //语音提示
                    startActivity<FunctionCommonHActivity>()
            }
        }
        mRvFunctionCommon.adapter = adapter

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_function
    }


    private inner class FunctionAdapter(data: List<SparseArray<String>>?) : BaseQuickAdapter<SparseArray<String>, BaseViewHolder>(R.layout.item_function, data) {

        override fun convert(helper: BaseViewHolder, item: SparseArray<String>) {
            val tvFunction = helper.getView<TextView>(R.id.tvFunction)
            tvFunction.setCompoundDrawablesWithIntrinsicBounds(null, resources.getDrawable(item.keyAt(0)), null, null)
            tvFunction.text = item.get(item.keyAt(0))
        }
    }


}
