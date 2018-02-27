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


class LoadingDialog : BaseDialogFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //tvTitle.setText(getArguments().getString("title"));
    }

    override fun getResoureId(): Int {
        return R.layout.dialog_loading
    }

    companion object {
        private val TAG = "LoadingDialog"

        fun show(title: String, manager: FragmentManager): LoadingDialog {
            val bundle = Bundle()
            bundle.putString("title", title)
            val tipDialog = LoadingDialog()
            tipDialog.arguments = bundle
            tipDialog.show(manager, TAG)
            return tipDialog
        }

        fun show(manager: FragmentManager): LoadingDialog {
            return show("", manager)
        }
    }


}
