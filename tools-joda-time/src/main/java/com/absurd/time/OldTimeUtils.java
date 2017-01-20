package com.absurd.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 *
 */
public class OldTimeUtils {
    private static ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
    public static Date convert(String source)
            throws ParseException {
        Date d = df.get().parse(source);
        return d;
    }
}
