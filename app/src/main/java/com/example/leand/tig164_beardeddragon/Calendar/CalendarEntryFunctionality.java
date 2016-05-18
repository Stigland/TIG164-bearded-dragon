package com.example.leand.tig164_beardeddragon.Calendar;

import android.graphics.drawable.ColorDrawable;

import com.example.leand.tig164_beardeddragon.R;
import com.roomorama.caldroid.CaldroidFragment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by leand on 2016-05-12.
 */
public class CalendarEntryFunctionality {

    static DateFormat timeFormatter = new SimpleDateFormat("yyyy-MM-dd kk:mm");
    static DateFormat dayFormatter = new SimpleDateFormat("EEE yyyy-MM-dd");
    static DateFormat hourFormatter = new SimpleDateFormat("kk:mm");

    //takes formatted String ("yyyy-MM-dd kk:mm")
    public static Date stringToDate(String dateString) {
        try {
            Date result = timeFormatter.parse(dateString);
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Returns a formatted string ("yyyy-MM-dd kk:mm")
    public static String dateToString(Date date) {
        String result = timeFormatter.format(date);
        System.out.println(result);
        return result;
    }

<<<<<<< HEAD
    //Returns a formatted string ("yyyy-MM-dd kk:mm")
    public static String dateToDayString(Date date) {
        String result = dayFormatter.format(date);
        System.out.println(result);
        return result;
    }

    //Returns a formatted string ("yyyy-MM-dd kk:mm")
    public static String dateTotimeString(Date date) {
        String result = hourFormatter.format(date);
        System.out.println(result);
        return result;
    }

=======
>>>>>>> master
}
