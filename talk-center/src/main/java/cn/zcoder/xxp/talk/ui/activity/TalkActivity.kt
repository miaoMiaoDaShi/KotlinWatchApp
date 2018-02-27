package cn.zcoder.xxp.talk.ui.activity

import android.Manifest
import android.os.Bundle
import android.view.Gravity
import android.view.MotionEvent
import cn.zcoder.xxp.base.Configurator
import cn.zcoder.xxp.base.ext.toast
import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.provider.arouter.RouterPath
import cn.zcoder.xxp.talk.R
import cn.zcoder.xxp.talk.utlis.AudioRecoderUtils
import cn.zcoder.xxp.talk.widgets.AudioRecoderDialog
import cn.zcoder.xxp.ui.ToolBar
import com.alibaba.android.arouter.facade.annotation.Route

import com.tbruyelle.rxpermissions2.RxPermissions

import java.io.File
import java.util.ArrayList


import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_talk.*


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/24
 * Description :首页点进去语聊
 */
@Route(path = RouterPath.TalkCenter.PATH_TALK)
class TalkActivity : BaseActivity(), AudioRecoderUtils.OnAudioStatusUpdateListener {
    override fun getLayoutId(): Int {
        return R.layout.activity_talk
    }

    private val mRecoderDialog: AudioRecoderDialog by lazy {
        AudioRecoderDialog(this)
    }
    private val mRecoderUtils: AudioRecoderUtils by lazy {
        AudioRecoderUtils()
    }
    private var downT: Long = 0
    private val mRecordUrls: MutableList<String> by lazy {
        ArrayList<String>()
    }


    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle("语聊")
                .setOnLeftImageListener({ finish() })
        // .setRighticon()

        setupRecord()
    }

    private fun setupRecord() {
        val rxPermissions = RxPermissions(this)
        rxPermissions.request(Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(object : Observer<Boolean> {
                    override fun onNext(t: Boolean) {
                        mRecoderDialog.setShowAlpha(0.98f)
                        mRecoderUtils.setOnAudioStatusUpdateListener(this@TalkActivity)
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {
                        toast("相关权限被拒绝,无法正常使用~")
                        finish()
                    }

                    override fun onComplete() {

                    }
                })
    }

    override fun bindListener() {
        super.bindListener()

        btnTouchToTalk.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    val dir = Configurator.appFolder
                    File(dir).mkdirs()
                    val url = "$dir/${mRecordUrls.size}.amr"
                    mRecordUrls.add(url)
                    mRecoderUtils.startRecord(url)
                    downT = System.currentTimeMillis()
                    mRecoderDialog.showAtLocation(v, Gravity.CENTER, 0, 0)
                    true
                }
                MotionEvent.ACTION_UP -> {
                    if (mRecoderUtils.stopRecord() < 1000) {
                        toast("录音时间过短~")
                    }
                    mRecoderDialog.dismiss()
                    true
                }
                else -> false
            }
        }
    }


    override fun onUpdate(db: Double) {
        val level = db.toInt()
        mRecoderDialog.setLevel(level)
        mRecoderDialog.setTime(System.currentTimeMillis() - downT)
    }

}
