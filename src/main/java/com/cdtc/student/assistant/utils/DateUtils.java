package com.cdtc.student.assistant.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by pcc on 2018/4/30.
 */
public class DateUtils {

    public static String getFormatNow() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(currentTime);

    }

    public static void main(String[] d ){
        System.out.println(DateUtils.getFormatNow());
    }
}
