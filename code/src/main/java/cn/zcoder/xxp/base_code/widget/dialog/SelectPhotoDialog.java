package cn.zcoder.xxp.base_code.widget.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.View;

import cn.zcoder.xxp.base_code.R;


/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/11/23
 * Description :
 */


public class SelectPhotoDialog extends BaseDialogFragment {
    private static final String TAG = "SelectPhotoDialog";


    public static SelectPhotoDialog show(FragmentManager manager) {

        SelectPhotoDialog tipDialog = new SelectPhotoDialog();
        tipDialog.show(manager, TAG);
        return tipDialog;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int getResoureId() {
        return R.layout.dialog_select_photo;
    }

    @Override
    public void onResume() {
        super.onResume();

       // adjustSizeGravity(ScreenUtils.getScreenWidth(), -1, Gravity.BOTTOM);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setStyle(0, R.style.dialogTransparent);
        return super.onCreateDialog(savedInstanceState);
    }

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

    private OnClickListener mOnClickListener;

    public void setOnClickListener(OnClickListener listener) {
        this.mOnClickListener = listener;
    }

    public interface OnClickListener {
        void onOpen();
    }
}
