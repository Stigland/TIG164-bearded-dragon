package com.example.leand.tig164_beardeddragon.Calendar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.leand.tig164_beardeddragon.Calendar.CalendarEntry;
import com.example.leand.tig164_beardeddragon.Contacts.Contact;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Date;

/**
 * Created by edvin on 2016-05-12.
 */
public class CalendarDataPump {

    public static List<CalendarEntry> getData() {

        List <CalendarEntry> ce = fetchFromDB();
        List <CalendarEntry> ce2 = new ArrayList<CalendarEntry>();


        for (CalendarEntry c: ce2) {
            List<Object> cl = new ArrayList <Object>();
            cl.add (c.getStartDate());
            cl.add (c.getEndDate());
            cl.add (c.isInterested());
            cl.add (c.isAvailableShift());
            cl.add (c.isBookedshift());
            cl.add (c.isAbsenceRequest());


        }

        return ce;

    }

    public static List <CalendarEntry> fetchFromDB (){

        List <CalendarEntry> ce = new ArrayList<CalendarEntry>();
/*
        ce.add(new CalendarEntry("2016-05-02 06:30","2016-05-11 14:30", true, false, false, true ));
        ce.add(new CalendarEntry("2016-05-11 06:30","2016-05-11 14:30", true, false, false, false ));
        ce.add(new CalendarEntry("2016-05-12 06:30","2016-05-12 14:30", false, false, true, false ));
        ce.add(new CalendarEntry("2016-05-13 06:30","2016-05-13 14:30", false, false, true, false ));
        ce.add(new CalendarEntry("2016-05-27 06:30","2016-05-11 14:30", false, false, true, false ));
        ce.add(new CalendarEntry("2016-05-28 06:30","2016-05-11 14:30", true, false, false, false ));
        ce.add(new CalendarEntry("2016-05-01 06:30","2016-05-11 14:30", false, true, false, false ));
        ce.add(new CalendarEntry("2016-05-31 06:30","2016-05-11 14:30", true, false, false, false ));
        ce.add(new CalendarEntry("2016-06-01 06:30","2016-05-11 14:30", true, false, false, false ));
        ce.add(new CalendarEntry("2016-06-04 06:30","2016-05-11 14:30", true, false, false, false ));
        ce.add(new CalendarEntry("2016-06-05 06:30","2016-05-11 14:30", false, false, false, true ));
*/
        SQLiteDatabase sqLiteDatabase = CalendarActivity.getSql();
        Cursor query = sqLiteDatabase.rawQuery("select * from shift", null);
        if(query.moveToFirst()) {
            do {
                CalendarEntry calendarEntry = new CalendarEntry("","",false,false,false,false);
                //cycle through all records
                String startDate = query.getString(0);
                String endDate = query.getString(1);
                boolean interested = intToBool(query.getInt(2));
                boolean availableShift = intToBool(query.getInt(3));
                boolean bookedShift = intToBool(query.getInt(4));
                boolean absenceRequest = intToBool(query.getInt(5));

                calendarEntry.setStartDate(startDate);
                calendarEntry.setEndDate(endDate);
                calendarEntry.setInterested(interested);
                calendarEntry.setAvailableShift(availableShift);
                calendarEntry.setBookedshift(bookedShift);
                calendarEntry.setAbsenceRequest(absenceRequest);

                ce.add(calendarEntry);
               // Toast.makeText(CalendarActivity.class, "Name= " + startDate + ", phone= " + endDate + ", email= " + interested, Toast.LENGTH_LONG).show();
            } while(query.moveToNext());
        } else {
            //Toast.makeText(CalendarActivity.class,"Error retrieving data",Toast.LENGTH_LONG).show();
        };

        //sqLiteDatabase.close();



        return ce;

    }

    public static List<CalendarEntry> getDB() {
        List<CalendarEntry> ce = new ArrayList<CalendarEntry>();
        ce = fetchFromDB();
        return ce;
    }

    public static boolean intToBool(int i) {
        return i>0;
    }

    public static int boolToInt(boolean b) {
        if(b) {
            return 1;
        } else {
            return 0;
        }
    }

}