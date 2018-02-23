package cn.zcoder.xxp.base_code.widget.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.TextView;

import cn.zcoder.xxp.base_code.R;


/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/11/23
 * Description :
 */


public class LoadingDialog extends BaseDialogFragment {
    private static final String TAG = "LoadingDialog";

    public static LoadingDialog show(String title, FragmentManager manager) {
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        LoadingDialog tipDialog = new LoadingDialog();
        tipDialog.setArguments(bundle);
        tipDialog.show(manager, TAG);
        return tipDialog;
    }

    public static LoadingDialog show(FragmentManager manager) {
        return show("", manager);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //tvTitle.setText(getArguments().getString("title"));
    }

    @Override
    protected int getResoureId() {
        return R.layout.dialog_loading;
    }



}
