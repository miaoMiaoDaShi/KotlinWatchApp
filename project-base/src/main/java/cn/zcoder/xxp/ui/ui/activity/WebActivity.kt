package cn.zcoder.xxp.ui.ui.activity

import android.content.Context
import android.os.Bundle
import android.widget.LinearLayout
import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.ui.R
import cn.zcoder.xxp.ui.ToolBar
import com.just.library.AgentWeb
import kotlinx.android.synthetic.main.activity_web.*
import org.jetbrains.anko.startActivity


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/27
 * Description :
 */

class WebActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_web
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        findViewById<ToolBar>(R.id.mToolBar)
                .setTitle(intent.getStringExtra("title"))
                .setOnRightImageListener { finish() }

        AgentWeb.with(this)//传入Activity
                .setAgentWebParent(llContent, LinearLayout.LayoutParams(-1, -1))//传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams
                .useDefaultIndicator()// 使用默认进度条
                .defaultProgressBarColor() // 使用默认进度条颜色
                .createAgentWeb()//
                .ready()
                .go(intent.getStringExtra("url"))
    }

    companion object {
        fun startAction(context: Context, title: String = "未定义", url: String) {
            context.startActivity<WebActivity>("title" to title, "url" to url)
        }
    }
}