package com.absurd.time;


import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/***
 *
 *
 */
public class TimeUtils {
    public static DateTime converToDateTime(Date date){
        DateTime dt = new DateTime(date);
        return dt;
    }

    public static Date converToDate(DateTime dt){
        return  dt.toDate();
    }

    public static GregorianCalendar converToGregorianCalendar(DateTime dt){
        return  dt.toGregorianCalendar();
    }

    public static DateTime makeDateTime(int year,int month,int day){
        DateTime dt = new DateTime(year, month, day,0,0);
        return dt;
    }

    public static DateTime parse(String dateStr,String pattern){
        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
        DateTime dt = fmt.parseDateTime(dateStr);
        return dt;
    }


    public static DateTime parse(String dateStr,String pattern,Locale locale){
        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
        fmt = fmt.withLocale(locale);
        DateTime dt = fmt.parseDateTime(dateStr);
        return dt;
    }

    /***
     * 获取上月月底最后一刻
     * @return
     */
    public static Date getLastOfPastMonth(){
        DateTime dt = new DateTime()
                .withDayOfMonth(1)
                .withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0)
                .withMillisOfSecond(0);
        dt =   dt.plusMillis(-1);
        return  dt.toDate();
    }

    /***
     * 获取本月底最后一刻
     * @return
     */
    public static Date getLastOfMonth(){
        DateTime dt = new DateTime()
                .withDayOfMonth(1)
                .withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0)
                .withMillisOfSecond(0);
        dt =   dt.plusMonths(1).plusMillis(-1);
        return  dt.toDate();
    }

    /***
     * 获取本年开始那一刻
     * @return
     */
    public static Date getFirstDayOfYear(){
        DateTime dt = new DateTime()
                .withMonthOfYear(1)
                .withDayOfMonth(1)
                .withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0)
                .withMillisOfSecond(0);
        return  dt.toDate();
    }


    /***
     * 获取去年结束那一刻
     * @return
     */
    public static Date getLastOfPastYear(){
        DateTime dt = new DateTime()
                .withMonthOfYear(1)
                .withDayOfMonth(1)
                .withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0)
                .withMillisOfSecond(0);
        dt =   dt.plusMillis(-1);
        return  dt.toDate();
    }


    public static Period diff(Date d1, Date d2){
        Period p = new Period(d1.getTime(), d2.getTime(), PeriodType.days());
        return p;
    }

    public static String toStr(Date date,String pattern){
        DateTime dt = new DateTime(date);
        String b = dt.toString(pattern);
        return b;
    }


    public static String toStr(Date date,String pattern,Locale locale){
        DateTime dt = new DateTime(date);
        String b = dt.toString(pattern, locale);
        return b;
    }


}
