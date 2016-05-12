package com.example.leand.tig164_beardeddragon.Calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by leand on 2016-05-12.
 */
public class CalendarEntryFunctionality {

    static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd kk:mm");

    //takes formatted String ("yyyy-MM-dd kk:mm")
    public static Date stringToDate(String dateString) {
        try {
            Date result = formatter.parse(dateString);
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Returns a formatted string ("yyyy-MM-dd kk:mm")
    public static String dateToString(Date date) {
        String result = formatter.format(date);
        System.out.println(result);
        return result;
    }

    public static void updateCalendarStatuses(){

    }
}
