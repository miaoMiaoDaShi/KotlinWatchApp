package cn.zcoder.xxp.base_code.widget.dialog

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.View
import android.widget.TextView
import cn.zcoder.xxp.base_code.R


/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/11/23
 * Description :
 */


class TipDialog : BaseDialogFragment() {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //tvTitle.setText(arguments.getString("title"))
    }

    override fun getResoureId(): Int {
        return R.layout.dialog_tip
    }

    companion object {
        private val TAG = "TipDialog"


        fun show(title: String, manager: FragmentManager): TipDialog {
            val bundle = Bundle()
            bundle.putString("title", title)
            val tipDialog = TipDialog()
            tipDialog.arguments = bundle
            tipDialog.show(manager, TAG)
            return tipDialog
        }
    }


}
