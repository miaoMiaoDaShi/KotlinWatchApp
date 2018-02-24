package cn.zcoder.xxp.ui.widget.dialog

import android.app.Dialog
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


class SelectPhotoDialog : BaseDialogFragment() {

    //    @OnClick({R.id.btnOpenAlbum, R.id.btnCancel})
    //    public void onViewClicked(View view) {
    //        switch (view.getId()) {
    //            case R.id.btnOpenAlbum:
    //                if (mOnClickListener != null) {
    //                    mOnClickListener.onOpen();
    //                }
    //                break;
    //            case R.id.btnCancel:
    //                break;
    //            default:
    //        }
    //
    //        dismiss();
    //    }

    private var mOnClickListener: OnClickListener? = null

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getResoureId(): Int {
        return R.layout.dialog_select_photo
    }

    override fun onResume() {
        super.onResume()

        // adjustSizeGravity(ScreenUtils.getScreenWidth(), -1, Gravity.BOTTOM);
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        setStyle(0, R.style.dialogTransparent)
        return super.onCreateDialog(savedInstanceState)
    }

    fun setOnClickListener(listener: OnClickListener) {
        this.mOnClickListener = listener
    }

    interface OnClickListener {
        fun onOpen()
    }

    companion object {
        private val TAG = "SelectPhotoDialog"


        fun show(manager: FragmentManager): SelectPhotoDialog {

            val tipDialog = SelectPhotoDialog()
            tipDialog.show(manager, TAG)
            return tipDialog
        }
    }
}
