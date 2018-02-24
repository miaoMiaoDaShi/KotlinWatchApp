package cn.zcoder.xxp.ui.widget.dialog

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.View

import cn.zcoder.xxp.ui.R


/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/11/23
 * Description :
 */


class InputRelationDialog : BaseDialogFragment() {


    //    @OnClick({R.id.btnCancel, R.id.btnConfirm})
    //    public void onViewClicked(View view) {
    //        switch (view.getId()) {
    //            case R.id.btnCancel:
    //                if (mOnClickListener != null) {
    //                    mOnClickListener.onCancel();
    //                }
    //                break;
    //            case R.id.btnConfirm:
    //                final String name = txtName.getText().toString().trim();
    //                if (TextUtils.isEmpty(name)) {
    //                    ToastUtils.show("名称不能为空~");
    //                    return;
    //                }
    //                if (mOnClickListener != null) {
    //                    mOnClickListener.onConfirm(name);
    //                }
    //
    //                break;
    //            default:
    //        }
    //
    //        dismiss();
    //    }

    private var mOnClickListener: OnClickListener? = null


    override fun getResoureId(): Int {
        return R.layout.dialog_input_relation
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        mOnClickListener = onClickListener
    }

    interface OnClickListener {
        fun onConfirm(s: String)

        fun onCancel()
    }

    companion object {
        private val TAG = "InputRelationDialog"


        fun show(manager: FragmentManager): InputRelationDialog {
            val tipDialog = InputRelationDialog()
            tipDialog.show(manager, TAG)
            return tipDialog
        }
    }
}
