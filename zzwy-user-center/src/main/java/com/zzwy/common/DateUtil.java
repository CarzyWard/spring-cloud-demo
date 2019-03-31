package com.zzwy.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author zzwy
 * @date 2019/3/31
 */
public class DateUtil {

    /**
     * 根据格式化类型将指定日期时间的格式化成相应的字符串形式的(y-年,M-月,d-日,H-时,m-分，s-秒,S-毫秒)日期时间;
     *
     * @param date   Date 指定的日期
     * @param format String 格式字符串
     * @return String 当前时间
     */
    public static String getCntDtStr(Date date, String format) {
        SimpleDateFormat dtFmt = new SimpleDateFormat(format);
        String nowDtStr = dtFmt.format(date);
        return nowDtStr;
    }

    /**
     * 取得系统当前的日期时间
     * @return String yyyy-MM-dd HH:mm:ss
     */
    public static String curDateTime() {
        return getCntDtStr(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

}
