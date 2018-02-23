package cn.zcoder.xxp.talk_center.utlis;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/2/11
 * Description :
 */

public class ProgressTextUtils {

    public static String getProgressText(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time));
        double minute = calendar.get(Calendar.MINUTE);
        double second = calendar.get(Calendar.SECOND);

        DecimalFormat format = new DecimalFormat("00");
        return format.format(minute) + ":" + format.format(second);
    }
}
