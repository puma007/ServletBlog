package cn.com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tanhaiyuan on 2015/7/5.
 */
public class DateUtil {
    public static java.sql.Date UtilToSqlDate(java.util.Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

    public static java.util.Date SqlToUtilDate(java.sql.Date date) {
        java.util.Date utilDate = new java.util.Date(date.getTime());
        return utilDate;
    }

    public static String formatDate(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(date);
    }
    public static String formatDateTime(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(date);
    }
}
