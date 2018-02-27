package cn.zcoder.xxp.bnwatch.ui.activity

import android.Manifest
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.View
import cn.zcoder.xxp.base.ext.getRealFilePath
import cn.zcoder.xxp.base.ext.onClick
import cn.zcoder.xxp.base.ext.toast

import com.google.zxing.BinaryBitmap
import com.google.zxing.MultiFormatReader
import com.google.zxing.RGBLuminanceSource
import com.google.zxing.Result
import com.google.zxing.common.HybridBinarizer

import com.tbruyelle.rxpermissions2.RxPermissions
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.engine.impl.GlideEngine

import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.bnwatch.R
import cn.zcoder.xxp.ui.ToolBar
import cn.zcoder.xxp.ui.widget.dialog.AddWatchNeedPermissionDialog
import cn.zcoder.xxp.ui.widget.dialog.SelectPhotoDialog
import cn.zcoder.xxp.ui.widget.dialog.TipDialog
import kotlinx.android.synthetic.main.activity_add_watch.*
import me.dm7.barcodescanner.zxing.ZXingScannerView

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/26
 * Description :添加手表
 */

class AddWatchActivity : BaseActivity(), ZXingScannerView.ResultHandler, View.OnClickListener {


    override fun getLayoutId(): Int = R.layout.activity_add_watch

    private val REQUEST_CODE_CHOOSE = 1


    override fun initView(savedInstanceState: Bundle?) {
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle(getString(R.string.scan_page_title))
                .setOnLeftImageListener({ finish() })
                .setOnRightTextListener("相册", { selectImage() }
                )

        checkPermission()
    }

    /**
     * 去相册选择图片
     */
    private fun selectImage() {
        val dialog = SelectPhotoDialog.show(supportFragmentManager)
        dialog.setOnClickListener(object : SelectPhotoDialog.OnClickListener {
            override fun onOpen() {
                Matisse.from(this@AddWatchActivity)
                        .choose(MimeType.allOf())
                        .countable(true)
                        .maxSelectable(1)
                        .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                        //.addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f)
                        .imageEngine(GlideEngine())
                        .forResult(REQUEST_CODE_CHOOSE)
            }

        })

    }

    /**
     * 检测权限
     */
    private fun checkPermission() {
        RxPermissions(this)
                .request(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe { granted ->
                    if (granted!!) { // Always true pre-M

                    } else {
                        toast("你拒绝了相关权限，扫码功能无法正常使用。")
                        finish()
                    }
                }
    }

    protected override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            val uri = Matisse.obtainResult(data)[0]
            decodeBitmap(uri)
        }
    }

    /**
     * 解码
     *
     * @param uri
     */
    private fun decodeBitmap(uri: Uri) {
        val bitmap = BitmapFactory.decodeFile(getRealFilePath(getApplicationContext(), uri))
        val intArray = IntArray(bitmap.width * bitmap.height)
        bitmap.getPixels(intArray, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)

        val source = RGBLuminanceSource(bitmap.width, bitmap.height, intArray)
        val binaryBitmap = BinaryBitmap(HybridBinarizer(source))

        val reader = MultiFormatReader()
        try {
            val result = reader.decode(binaryBitmap)
            handleResult(result)

        } catch (e: Exception) {
            toast("没有识别到二维码信息~")
            e.printStackTrace()
        }

    }

    protected override fun onResume() {
        super.onResume()
        zxingView.setResultHandler(this)
        zxingView.startCamera()
        zxingView.setAutoFocus(true)
    }

    protected override fun onStop() {
        super.onStop()
        zxingView.stopCamera()
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnConfirm -> {
                val dialog = AddWatchNeedPermissionDialog.show(supportFragmentManager)
            }
            else -> {
            }
        }
    }

    override fun bindListener() {
        super.bindListener()
        btnConfirm.onClick(this)
    }

    override fun handleResult(result: Result) {
        val dialog = TipDialog.show("成功绑定", supportFragmentManager)
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }, 2000)
    }

}
