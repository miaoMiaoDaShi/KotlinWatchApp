package cn.zcoder.xxp.bnwatch.ui.activity

import android.view.View
import cn.zcoder.xxp.base.ext.onClick
import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.bnwatch.R
import cn.zcoder.xxp.provider.arouter.RouterPath
import cn.zcoder.xxp.ui.WarnDialog
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_mine.*
import org.jetbrains.anko.startActivity


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/26
 * Description :
 */

class MineActivity : BaseActivity(), View.OnClickListener {
    override fun getLayoutId(): Int {
        return R.layout.activity_mine
    }

    override fun bindListener() {
        super.bindListener()
        ivBack.onClick(this)
        tvAddWatch.onClick(this)
        llToMineData.onClick(this)
        tvSwitch.onClick(this)
        rlWatchNum.onClick(this)
        rlBindUnbind.onClick(this)
        rlSetting.onClick(this)
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivBack -> finish()
            R.id.tvAddWatch -> startActivity<AddWatchActivity>()
            R.id.llToMineData -> ARouter.getInstance().build(RouterPath.UserCenter.PATH_DETAIL).navigation()
            R.id.tvSwitch -> startActivity<ChangeWatchActivity>()
            R.id.rlWatchNum -> {
                val dialog = WarnDialog.show(supportFragmentManager, "", "")
                dialog.setOnClickListener(object : WarnDialog.OnClickListener {
                    override fun onConfirm() {
                        startActivity<WatchNumActivity>()
                    }

                    override fun onCancel() {

                    }
                })
            }
            R.id.rlBindUnbind -> startActivity<BindAndUnbindActivity>()
            R.id.rlSetting -> startActivity<SettingActivity>()
        }
    }


}