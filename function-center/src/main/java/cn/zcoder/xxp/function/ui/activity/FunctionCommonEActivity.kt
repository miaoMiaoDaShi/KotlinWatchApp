package cn.zcoder.xxp.function.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Switch
import android.widget.TextView

import com.bigkoo.pickerview.TimePickerView

import java.util.Date

import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.function.R
import cn.zcoder.xxp.ui.widget.ToolBar

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/25
 * Description :定时开关机
 */

class FunctionCommonEActivity : BaseActivity() {

    internal var switchView: Switch? = null
    internal var tvNo: TextView? = null
    internal var tvOff: TextView? = null
    private var mTimePickerView: TimePickerView? = null
    /**
     * 当前点击的View
     */
    private val mCurrentClickView: View? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_fun_common_e
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("定时开关机")
                .setOnLeftImageListener({finish()})

        initPickView()
    }

    private fun initPickView() {
        mTimePickerView = TimePickerView.Builder(this, TimePickerView.OnTimeSelectListener { date, v ->
            //                switch (mCurrentClickView.getId()) {
            //                    case R.id.tvNo:
            //                        break;
            //                    case R.id.tvOff:
            //                        break;
            //                    default:
            //                }
        })
                .gravity(Gravity.CENTER)
                .setContentSize(23)
                .setLabel("", "", "", "", "", "")
                .setType(booleanArrayOf(false, false, false, true, true, false))
                .build()
    }

    companion object {

        fun startAction(context: Context) {
            context.startActivity(Intent(context, FunctionCommonEActivity::class.java))
        }
    }

    //    @OnClick({R.id.btnCancel, R.id.btnConfirm, R.id.tvNo, R.id.tvOff})
    //    public void onViewClicked(View view) {
    //        mCurrentClickView = view;
    //        switch (view.getId()) {
    //            case R.id.btnCancel:
    //                break;
    //            case R.id.btnConfirm:
    //                break;
    //            case R.id.tvNo:
    //            case R.id.tvOff:
    //                mTimePickerView.show();
    //                break;
    //            default:
    //        }
    //    }

}
