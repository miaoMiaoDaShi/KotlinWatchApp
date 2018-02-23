package cn.zcoder.xxp.talk_center.utlis

import android.media.MediaRecorder
import android.os.Handler
import android.util.Log

import java.io.File
import java.io.IOException

/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/2/11
 * Description :
 */

class AudioRecoderUtils {

    private var filePath: String? = null
    private var mMediaRecorder: MediaRecorder? = null
    private val TAG = "MediaRecord"

    private var audioStatusUpdateListener: OnAudioStatusUpdateListener? = null

    private var startTime: Long = 0
    private var endTime: Long = 0

    private val mHandler = Handler()

    private val mUpdateMicStatusTimer = Runnable { updateMicStatus() }

    /**
     * 更新话筒状态
     */
    private val BASE = 1
    private val SPACE = 100// 间隔取样时间

    constructor() {
        this.filePath = "/dev/null"
    }

    constructor(file: File) {
        this.filePath = file.absolutePath
    }

    /**
     * 开始录音 使用amr格式
     * 录音文件
     *
     * @return
     */
    fun startRecord(filePath: String) {
        // 开始录音
        /* ①Initial：实例化MediaRecorder对象 */
        mMediaRecorder = MediaRecorder()
        mMediaRecorder!!.setAudioSource(MediaRecorder.AudioSource.MIC)// 设置麦克风
        /* ②设置音频文件的编码：AAC/AMR_NB/AMR_MB/Default 声音的（波形）的采样 */
        mMediaRecorder!!.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT)
        /*
             * ②设置输出文件的格式：THREE_GPP/MPEG-4/RAW_AMR/Default THREE_GPP(3gp格式
             * ，H263视频/ARM音频编码)、MPEG-4、RAW_AMR(只支持音频且音频编码要求为AMR_NB)
             */
        mMediaRecorder!!.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
        /* ③准备 */
        mMediaRecorder!!.setOutputFile(filePath)
        mMediaRecorder!!.setMaxDuration(MAX_LENGTH)

        try {
            /* ②setAudioSource/setVedioSource */

            mMediaRecorder!!.prepare()
            /* ④开始 */
            mMediaRecorder!!.start()
            // AudioRecord audioRecord.
            /* 获取开始时间* */
            startTime = System.currentTimeMillis()
            updateMicStatus()
            Log.i("ACTION_START", "startTime" + startTime)
        } catch (e: IllegalStateException) {
            Log.i(TAG, "call startAmr(File mRecAudioFile) failed!" + e.message)
        } catch (e: IOException) {
            Log.i(TAG, "call startAmr(File mRecAudioFile) failed!" + e.message)
        }

    }

    /**
     * 停止录音
     */
    fun stopRecord(): Long {
        try {
            if (mMediaRecorder == null) {
                return 0L
            }
            endTime = System.currentTimeMillis()
            Log.i("ACTION_END", "endTime" + endTime)
            mMediaRecorder!!.stop()
            mMediaRecorder!!.release()
            mHandler.removeCallbacks(mUpdateMicStatusTimer)
            Log.i("ACTION_LENGTH", "Time" + (endTime - startTime))
            return endTime - startTime
        } catch (e: RuntimeException) {
            e.printStackTrace()
            return 0
        }

    }

    fun setOnAudioStatusUpdateListener(audioStatusUpdateListener: OnAudioStatusUpdateListener) {
        this.audioStatusUpdateListener = audioStatusUpdateListener
    }

    private fun updateMicStatus() {
        if (mMediaRecorder != null) {
            val ratio = mMediaRecorder!!.maxAmplitude.toDouble() / BASE
            var db = 0.0// 分贝
            if (ratio > 1) {
                db = 20 * Math.log10(ratio)
                if (null != audioStatusUpdateListener) {
                    audioStatusUpdateListener!!.onUpdate(db)
                }
            }
            mHandler.postDelayed(mUpdateMicStatusTimer, SPACE.toLong())
        }
    }

    interface OnAudioStatusUpdateListener {
        fun onUpdate(db: Double)
    }

    companion object {
        val MAX_LENGTH = 1000 * 60 * 10// 最大录音时长1000*60*10;
    }
}
