package com.absurd.time;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Locale;

/***
 *
 */
public class TimeUtilsTest {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void joda_getnow(){
        DateTime dateTime = TimeUtils.converToDateTime(new Date());
        logger.info(dateTime.year().getAsString()
                +"-"+dateTime.monthOfYear().getAsString()
                +"-"+dateTime.dayOfMonth().getAsString()
                +"  "+dateTime.hourOfDay().getAsString()
                +":"+dateTime.minuteOfHour().getAsString()
                +":"+dateTime.secondOfMinute().getAsString());
    }

    @Test
    public void joda_parse_yyyyMMdd(){
        String dateStr = "20160511";
        DateTime dateTime =  TimeUtils.parse(dateStr,"yyyyMMdd");
        Assert.assertEquals(dateTime.year().get(),2016);
        Assert.assertEquals(dateTime.monthOfYear().get(),5);
        Assert.assertEquals(dateTime.dayOfMonth().get(),11);
    }

    @Test
    public void joda_parse_yyyyMMdd_split(){
        String dateStr = "2016-05-11";
        DateTime dateTime =  TimeUtils.parse(dateStr,"yyyy-MM-dd");
        Assert.assertEquals(dateTime.year().get(),2016);
        Assert.assertEquals(dateTime.monthOfYear().get(),5);
        Assert.assertEquals(dateTime.dayOfMonth().get(),11);
        dateStr = "16/5/11";
        dateTime =  TimeUtils.parse(dateStr,"yy/MM/dd");
        Assert.assertEquals(dateTime.year().get(),2016);
        Assert.assertEquals(dateTime.monthOfYear().get(),5);
        Assert.assertEquals(dateTime.dayOfMonth().get(),11);
    }

    @Test
    public void joda_parse_yyyyMMddHHmmss(){
        String dateStr = "2016-5-1 22:10:59";
        DateTime dateTime =  TimeUtils.parse(dateStr,"yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals(dateTime.year().get(),2016);
        Assert.assertEquals(dateTime.monthOfYear().get(),5);
        Assert.assertEquals(dateTime.dayOfMonth().get(),1);
        Assert.assertEquals(dateTime.hourOfDay().get(),22);
        Assert.assertEquals(dateTime.minuteOfHour().get(),10);
        Assert.assertEquals(dateTime.secondOfMinute().get(),59);

        dateStr = "星期六 五月 11 17:23:22 CST 2002";
        dateTime =  TimeUtils.parse(dateStr,"E MMM dd HH:mm:ss z yyyy");
        Assert.assertEquals(dateTime.year().get(),2002);
        Assert.assertEquals(dateTime.monthOfYear().get(),5);
        Assert.assertEquals(dateTime.dayOfMonth().get(),11);
        Assert.assertEquals(dateTime.hourOfDay().get(),17);
        Assert.assertEquals(dateTime.minuteOfHour().get(),23);
        Assert.assertEquals(dateTime.secondOfMinute().get(),22);
        Assert.assertEquals(dateTime.dayOfWeek().get(),6);
        logger.info(dateTime.toString("yyyy-MM-dd HH:mm:ss"));

        dateStr = "Sat May 11 17:23:22 CST 2002";
        dateTime =  TimeUtils.parse(dateStr,"E MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);
        Assert.assertEquals(dateTime.year().get(),2002);
        Assert.assertEquals(dateTime.monthOfYear().get(),5);
        Assert.assertEquals(dateTime.dayOfMonth().get(),11);
        Assert.assertEquals(dateTime.hourOfDay().get(),17);
        Assert.assertEquals(dateTime.minuteOfHour().get(),23);
        Assert.assertEquals(dateTime.secondOfMinute().get(),22);
        Assert.assertEquals(dateTime.dayOfWeek().get(),6);
        logger.info(dateTime.toString("yyyy-MM-dd HH:mm:ss"));

    }

    @Test
    public void joda_toStr(){
        logger.info(TimeUtils.toStr(new Date(),"E MMM dd HH:mm:ss z yyyy"));
        logger.info(TimeUtils.toStr(new Date(),"E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH));
    }

    @Test
    public void joda_getFirstDay_of_year(){
     Date date =   TimeUtils.getFirstDayOfYear();
        logger.info(TimeUtils.toStr(date,"E MMM dd HH:mm:ss z yyyy"));
    }

    @Test
    public void joda_getLastDay_of_pastYear(){
        Date date =   TimeUtils.getLastOfPastYear();
        logger.info(TimeUtils.toStr(date,"E MMM dd HH:mm:ss z yyyy"));
    }

    @Test
    public void joda_getLast_of_pastMonth(){
        Date date =   TimeUtils.getLastOfPastMonth();
        logger.info(TimeUtils.toStr(date,"E MMM dd HH:mm:ss z yyyy"));
    }

    @Test
    public void joda_getLast_of_Month(){
        Date date =   TimeUtils.getLastOfMonth();
        logger.info(TimeUtils.toStr(date,"E MMM dd HH:mm:ss z yyyy"));
    }

    @Test
    public void joda_diff(){
        Date date =   TimeUtils.getLastOfPastMonth();
        Period p =  TimeUtils.diff(date,new Date());
        logger.info("时间相差："+p.getYears()+" 年 "+p.getDays()+" 天 " + p.getHours()+ " 小时 "+p.getMinutes()+" 分钟"+p.getSeconds()+" 秒");

    }
}
