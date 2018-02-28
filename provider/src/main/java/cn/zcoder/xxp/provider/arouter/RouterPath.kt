package cn.zcoder.xxp.provider.arouter


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/26
 * Description :
 */

object RouterPath {
    class UserCenter {
        companion object {
            //登录页面
            const val PATH_LOGIN = "/userCenter/login"
            //宝贝资料
            const val PATH_DETAIL = "/userCenter/detail"
            //修改密码
            const val PATH_MOD_PWD = "/userCenter/modifyPwd"
        }
    }

    class FunctionCenter {
        companion object {
            //功能模块
            const val PATH_FUNCTION = "/functionCenter/main"
        }
    }

    class LocationCenter {
        companion object {
            //定位主界面
            const val PATH_LOCATION = "/locationCenter/main"
        }
    }

    class TalkCenter {
        companion object {
            //语言主页面
            const val PATH_TALK = "/talkCenter/main"
        }
    }

    class MessageCenter{
        companion object {
            //消息中心
            const val PATH_MSG = "/messageCenter/main"
        }
    }
}