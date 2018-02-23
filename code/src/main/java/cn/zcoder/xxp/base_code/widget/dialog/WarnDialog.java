package cn.zcoder.xxp.base_code.widget.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import cn.zcoder.xxp.base_code.R;

/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/11/23
 * Description : 个人中心  手表号码
 */


public class WarnDialog extends BaseDialogFragment {
    private static final String TAG = "WarnDialog";


    public static WarnDialog show(FragmentManager manager, String title, String content) {

        WarnDialog tipDialog = new WarnDialog();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("content", content);
        tipDialog.setArguments(bundle);
        tipDialog.show(manager, TAG);
        return tipDialog;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final String title = getArguments().getString("title");
        final String content = getArguments().getString("content");

        if (!TextUtils.isEmpty(title)) {
           // tvTitle.setText(title);

        }
        if (!TextUtils.isEmpty(content)) {
           // tvContent.setText(content);

        }

    }

    @Override
    protected int getResoureId() {
        return R.layout.dialog_warn;
    }

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

    private OnClickListener mOnClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }


    public interface OnClickListener {
        void onConfirm();

        void onCancel();
    }
}
