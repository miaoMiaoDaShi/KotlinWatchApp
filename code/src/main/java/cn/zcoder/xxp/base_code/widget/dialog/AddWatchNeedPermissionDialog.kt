package cn.zcoder.xxp.base_code.widget.dialog

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.View

import cn.zcoder.xxp.base_code.R
import cn.zcoder.xxp.base_code.ext.onClick
import kotlinx.android.synthetic.main.dialog_add_watch_need_permission.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.toast


/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/11/23
 * Description : 添加手表时,已经有了监护的提示框
 */


class AddWatchNeedPermissionDialog : BaseDialogFragment(), View.OnClickListener {


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getResoureId(): Int {
        return R.layout.dialog_add_watch_need_permission
    }

    override fun initListener() {
        super.initListener()
        mIvClose.onClick(this)
    }

    companion object {
        private val TAG = "AddWatchNeedPermissionDialog"


        fun show(manager: FragmentManager): AddWatchNeedPermissionDialog {
            val tipDialog = AddWatchNeedPermissionDialog()
            tipDialog.show(manager, TAG)
            return tipDialog
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mIvClose -> {
            }
            R.id.mBtnApplyFor -> {
            }
            else -> {
            }
        }
    }
    //
    //    @OnClick({R.id.ivClose, R.id.btnApplyFor})
    //    public void onViewClicked(View view) {
    //        switch (view.getId()) {
    //            case R.id.ivClose:
    //                break;
    //            case R.id.btnApplyFor:
    //                ApplyForActivity.startAction(getActivity());
    //                break;
    //            default:
    //
    //        }
    //        dismiss();
    //    }
}
