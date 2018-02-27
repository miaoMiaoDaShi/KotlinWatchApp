package cn.zcoder.xxp.base.mvp

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import cn.zcoder.xxp.base.mvp.presenter.MvpPresenter
import cn.zcoder.xxp.base.mvp.view.MvpView

class FragmentMvpDelegateImpl<V : MvpView, P : MvpPresenter<V>> : FragmentMvpDelegate<V, P> {
    constructor(mvpDelegateCallback: MvpDelegateCallback<V, P>) {
        if (mvpDelegateCallback == null) {
            throw NullPointerException("MvpDelegateCallback is null!")
        }
        mMvpDelegateCallback = mvpDelegateCallback
    }

    var mMvpDelegateCallback: MvpDelegateCallback<V, P>

    override fun onCreate(saved: Bundle?) {
    }

    override fun onDestroy() {
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        mMvpDelegateCallback.setPresenter(mMvpDelegateCallback.createPresenter())
        mMvpDelegateCallback.getPresenter().attachView(mMvpDelegateCallback.getMvpView())
    }

    override fun onDestroyView() {
        mMvpDelegateCallback.getPresenter().detachView()
    }

    override fun onPause() {
    }

    override fun onResume() {
    }

    override fun onStart() {
    }

    override fun onStop() {
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
    }

    override fun onAttach(activity: Activity) {
    }

    override fun onDetach() {
    }
}