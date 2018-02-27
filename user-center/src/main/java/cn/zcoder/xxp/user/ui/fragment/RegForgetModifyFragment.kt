package cn.zcoder.xxp.user.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import cn.zcoder.xxp.base.ui.fragment.BaseFragment
import cn.zcoder.xxp.user.R


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/24
 * Description : 注册,忘记密码,修改密码
 */


class RegForgetModifyFragment : BaseFragment() {

    override fun getLayoutId(): Int  = R.layout.fragment_rfm

    companion object {
        fun newInstance(type: Int, pageType: Int): Fragment {
            val bundle = Bundle()
            bundle.putInt("type", type)
            bundle.putInt("page", pageType)
            val fragment = RegForgetModifyFragment()
            fragment.setArguments(bundle)
            return fragment
        }
    }
}
