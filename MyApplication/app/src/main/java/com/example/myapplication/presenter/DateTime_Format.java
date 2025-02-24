package com.example.myapplication.presenter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime_Format {
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String TIME_FORMAT_12 = "hh:mm:ss a";
// Lấy ngày
    public String getDateString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        return format.format(date);
    }
    // Lấy gio (12 gio)
    public static String getTime12String(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(TIME_FORMAT_12);
        return format.format(date);}
}
