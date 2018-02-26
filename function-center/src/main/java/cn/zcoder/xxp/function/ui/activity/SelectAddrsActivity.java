package cn.zcoder.xxp.function.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.gson.Gson;


import java.io.IOException;


import cn.zcoder.xxp.base.ui.activity.BaseActivity;
import cn.zcoder.xxp.function.R;
import cn.zcoder.xxp.ui.widget.ToolBar;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.observers.DisposableObserver;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/30
 * Description : 在地图上选择位置
 */


public class SelectAddrsActivity extends BaseActivity {

    ToolBar toolBar;
    TextView tvCurrentAddrs;
    FrameLayout flMaps;
    //地图类型
    private int mMapType = -1;
    private FragmentManager mFragmentManager;
    private Fragment mGoogleMapFragment;
    private Fragment mBaiduMapFragment;

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, SelectAddrsActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolBar.setTitle("设置地址")
                .setOnLeftImageListener(new ToolBar.OnLeftImageListener() {
                    @Override
                    public void onClick() {
                        finish();
                    }
                })
                .setOnRightTextListener("保存", new ToolBar.OnRightTextListener() {
                    @Override
                    public void onClick() {
                        save();
                    }
                });



    }

    private void save() {

    }



    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_addrs;
    }



}
