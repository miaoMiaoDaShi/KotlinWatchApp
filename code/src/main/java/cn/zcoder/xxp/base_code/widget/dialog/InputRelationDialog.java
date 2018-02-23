package cn.zcoder.xxp.base_code.widget.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import cn.zcoder.xxp.base_code.R;


/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/11/23
 * Description :
 */


public class InputRelationDialog extends BaseDialogFragment {
    private static final String TAG = "InputRelationDialog";


    public static InputRelationDialog show(FragmentManager manager) {
        InputRelationDialog tipDialog = new InputRelationDialog();
        tipDialog.show(manager, TAG);
        return tipDialog;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int getResoureId() {
        return R.layout.dialog_input_relation;
    }


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

    private OnClickListener mOnClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onConfirm(String s);

        void onCancel();
    }
}
