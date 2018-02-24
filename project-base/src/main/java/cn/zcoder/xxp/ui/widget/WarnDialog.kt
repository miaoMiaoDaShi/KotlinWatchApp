package cn.zcoder.xxp.ui.widget

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.View
import cn.zcoder.xxp.ui.R
import cn.zcoder.xxp.ui.widget.dialog.BaseDialogFragment


/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/11/23
 * Description : 个人中心  手表号码
 */


class WarnDialog : BaseDialogFragment() {

    //
    //    @OnClick({R.id.btnCancel, R.id.btnConfirm})
    //    public void onViewClicked(View view) {
    //        switch (view.getId()) {
    //            case R.id.btnCancel:
    //                if (mOnClickListener != null) {
    //                    mOnClickListener.onCancel();
    //                }
    //                break;
    //            case R.id.btnConfirm:
    //
    //                if (mOnClickListener != null) {
    //                    mOnClickListener.onConfirm();
    //                }
    //
    //                break;
    //            default:
    //        }
    //
    //        dismiss();
    //    }

    private var mOnClickListener: OnClickListener? = null


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments.getString("title")
        val content = arguments.getString("content")

//        if (!TextUtils.isEmpty(title)) {
//            tvTitle.text = title
//
//        }
//        if (!TextUtils.isEmpty(content)) {
//            tvContent.setText(content);
//
//        }

    }

    override fun getResoureId(): Int {
        return R.layout.dialog_warn
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        mOnClickListener = onClickListener
    }


    interface OnClickListener {
        fun onConfirm()

        fun onCancel()
    }

    companion object {
        private val TAG = "WarnDialog"


        fun show(manager: FragmentManager, title: String, content: String): WarnDialog {

            val tipDialog = WarnDialog()
            val bundle = Bundle()
            bundle.putString("title", title)
            bundle.putString("content", content)
            tipDialog.arguments = bundle
            tipDialog.show(manager, TAG)
            return tipDialog
        }
    }
}
