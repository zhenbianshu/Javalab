package com.common;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * created by xiepengfei on 2018/12/12
 */
public class DateFormat {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        DateTime dateTime = dateTimeFormatter.parseDateTime("2018-11-24T13:11:09+0800");
        System.out.println(dateTime.getHourOfDay());

        DateTime dateTime1 = dateTimeFormatter.parseDateTime("2018-11-24T13:05:16+0800");
        System.out.println(dateTime1.millisOfDay().get());

        System.out.println(dateTime.getMillis());

        DateTimeFormatter newFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss:SSS");
        DateTime dateTime2 = newFormatter.parseDateTime("2019-01-21 12:08:35:038");
        System.out.println(dateTime2.getMillis());

    }
}
