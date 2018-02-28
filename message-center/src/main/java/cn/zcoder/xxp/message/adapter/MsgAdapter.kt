package cn.zcoder.xxp.message.adapter

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

import cn.zcoder.xxp.message.R
import cn.zcoder.xxp.message.entity.MsgInfo


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/29
 * Description :
 */


abstract class MsgAdapter
/**
 * Same as QuickAdapter#QuickAdapter(Context,int) but with
 * some initialization data.
 *
 * @param data A new list is created out of this one to avoid mutable list
 */
(data: List<MsgInfo>) : BaseMultiItemQuickAdapter<MsgInfo, BaseViewHolder>(data) {
    init {
        addItemType(MsgInfo.TYPE[0], R.layout.item_msg)
        addItemType(MsgInfo.TYPE[1], R.layout.item_msg_apply_for)
    }

}
