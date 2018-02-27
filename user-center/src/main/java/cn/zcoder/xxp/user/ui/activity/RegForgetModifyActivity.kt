package cn.zcoder.xxp.user.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.View
import cn.zcoder.xxp.base.ext.onClick


import cn.zcoder.xxp.base.ui.activity.BaseActivity
import cn.zcoder.xxp.ui.ToolBar
import cn.zcoder.xxp.user.R
import cn.zcoder.xxp.user.ui.fragment.RegForgetModifyFragment
import kotlinx.android.synthetic.main.activity_reg_forget_modify.*

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/24
 * Description :注册,忘记密码,修改密码(0,1,2)跳过来的
 */

class RegForgetModifyActivity : BaseActivity(), View.OnClickListener {


    //    @BindView(R.id.tab)
//    internal var tab: TabLayout? = null
//    @BindView(R.id.viewPager)
//    internal var viewPager: ViewPager? = null
//    @BindView(R.id.toolBar)
    lateinit var toolBar: ToolBar
//    @BindView(R.id.ivBack)
//    internal var ivBack: ImageView? = null




    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        toolBar = findViewById(R.id.mToolBar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initType()

    }


    private fun initType() {
        val pageType = intent.getIntExtra("type", 0)
        when (pageType) {
            PAGE_TYPE_REGISTER -> resources.getStringArray(R.array.register_type)
            PAGE_TYPE_FORGET_PWD -> resources.getStringArray(R.array.forget_pwd_type)
            PAGE_TYPE_MODIFY_PWD -> resources.getStringArray(R.array.modify_pwd_type)
            else -> arrayOfNulls(0)
        }?.let {
            switchViewForPageType(pageType)
            setUpViewPager(it, pageType)
        }
    }

    /**
     * 根据类型  进行大局视图样的切换
     *
     * @param pageType
     */
    private fun switchViewForPageType(pageType: Int) {
        when (pageType) {
            PAGE_TYPE_REGISTER, PAGE_TYPE_FORGET_PWD -> {
                toolBar.setVisibility(View.GONE)
                ivBack.visibility = View.VISIBLE
            }
            PAGE_TYPE_MODIFY_PWD -> toolBar.setTitle(getString(R.string.modify_pwd))
                    .setOnLeftImageListener({ finish() })
        }
    }

    private fun setUpViewPager(titls: Array<String>, pageType: Int) {
        viewPager!!.adapter = PageAdapter(supportFragmentManager, titls, pageType)
        tab!!.setupWithViewPager(viewPager)
    }


    override fun bindListener() {
        super.bindListener()
        ivBack.onClick(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_reg_forget_modify
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ivBack -> {
                finish()
            }
            else -> {
            }
        }
    }


    private class PageAdapter(fm: FragmentManager, private val typeTitles: Array<String>, private val pageType: Int) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            val fragment: Fragment? = null
            when (pageType) {
                0 -> {
                }
                1 -> {
                }
                2 -> {
                }
            }
            return RegForgetModifyFragment.newInstance(position, pageType)
        }

        override fun getCount(): Int {
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return typeTitles[position]
        }
    }

    companion object {

        /**
         * 注册使用
         */
        const val PAGE_TYPE_REGISTER = 0
        /**
         * 忘记密码使用
         */
        const val PAGE_TYPE_FORGET_PWD = 1
        /**
         * 修改密码使用
         */
        const val PAGE_TYPE_MODIFY_PWD = 2


        fun startAction(context: Context, type: Int) {
            val intent = Intent(context, RegForgetModifyActivity::class.java)
            intent.putExtra("type", type)
            context.startActivity(intent)
        }
    }
}
