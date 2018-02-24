package cn.zcoder.xxp.base.net


import android.os.Parcel
import android.os.Parcelable

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/8
 * Description :
 */

class BaseResponse : Parcelable {

    var status: Int = 0
    var resmsg: String? = null
    var totalrow: Int = 0


    val isOk: Boolean
        get() = status == 0

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(this.status)
        dest.writeString(this.resmsg)
        dest.writeInt(this.totalrow)
    }


    protected constructor(`in`: Parcel) {
        this.status = `in`.readInt()
        this.resmsg = `in`.readString()
        this.totalrow = `in`.readInt()
    }

    companion object {

        val CREATOR: Parcelable.Creator<BaseResponse> = object : Parcelable.Creator<BaseResponse> {
            override fun createFromParcel(source: Parcel): BaseResponse {
                return BaseResponse(source)
            }

            override fun newArray(size: Int): Array<BaseResponse?> {
                return arrayOfNulls(size)
            }
        }
    }
}
