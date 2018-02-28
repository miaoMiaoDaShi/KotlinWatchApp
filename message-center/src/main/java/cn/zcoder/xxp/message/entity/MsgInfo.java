package cn.zcoder.xxp.message.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/29
 * Description :
 */


public class MsgInfo implements MultiItemEntity {
    private String title;
    private int type;
    private int status;
    private boolean isChecked;
    private String des;
    public static final int TYPE[] = {0, 1};

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int getItemType() {
        return TYPE[status];
    }
}
