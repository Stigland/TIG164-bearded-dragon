package com.example.leand.tig164_beardeddragon.Calendar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.example.leand.tig164_beardeddragon.MainActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by leand on 2016-05-10.
 */
public class CalendarEntryDatabase {

    private static SQLiteDatabase sql;

    public static void createDB(SQLiteDatabase sqLiteDatabase) {

        //Drops existing tables
        //sqLiteDatabase.execSQL("DROP TABLE shift");


        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS shift (" +
                "startDate String primary key," +
                "endDate String," +
                "interested bool," +
                "availableShift bool," +
                "bookedShift bool," +
                "absenceRequest bool" +
                ");");
        try {
            //Insert new values in DB
            sqLiteDatabase.execSQL("Insert into shift values('2016-05-01 06:30','2016-05-01 14:30', 0, 1, 0, 0 );");
            sqLiteDatabase.execSQL("Insert into shift values('2016-05-02 06:30','2016-05-02 14:30', 1, 0, 0, 0 );");
            sqLiteDatabase.execSQL("Insert into shift values('2016-05-11 06:30','2016-05-11 14:30', 1, 0, 0, 0 );");
            sqLiteDatabase.execSQL("Insert into shift values('2016-05-12 06:30','2016-05-12 14:30', 0, 0, 1, 0 );");
            sqLiteDatabase.execSQL("Insert into shift values('2016-05-13 06:30','2016-05-13 14:30', 0, 0, 1, 0 );");
            sqLiteDatabase.execSQL("Insert into shift values('2016-05-27 06:30','2016-05-11 14:30', 0, 0, 1, 0 );");
            sqLiteDatabase.execSQL("Insert into shift values('2016-05-28 06:30','2016-05-28 14:30', 1, 0, 0, 0 );");
            sqLiteDatabase.execSQL("Insert into shift values('2016-05-31 06:30','2016-05-31 14:30', 1, 0, 0, 0 );");
            sqLiteDatabase.execSQL("Insert into shift values('2016-06-01 06:30','2016-06-01 14:30', 0, 0, 1, 0 );");
            sqLiteDatabase.execSQL("Insert into shift values('2016-06-04 06:30','2016-06-04 14:30', 1, 0, 0, 0 );");
            sqLiteDatabase.execSQL("Insert into shift values('2016-06-05 06:30','2016-06-05 14:30', 0, 0, 0, 1 );");
        } catch (SQLiteException e){
            if (e.getMessage().toString().contains("no such table")){
                Log.e("Creating table because it doesn't exist!", "" );
                // create table
                // re-run query, etc.
            }
        }

        public static void updateDB(Date start, Date end, boolean interested,
                                    boolean availableShift, boolean bookedShift,
                                    boolean absenceRequest) {
            SQLiteDatabase sql = MainActivity.sql;
            String startDate = CalendarEntryFunctionality.dateToString(start);
            String endDate = CalendarEntryFunctionality.dateToString(end);
            int interestedInt CalendarDataPump.boolToInt(interested);
            int bookedShiftInt CalendarDataPump.boolToInt(bookedShift);
            int absenceRequestInt CalendarDataPump.boolToInt(absenceRequest);
            int availableShiftInt CalendarDataPump.boolToInt(availableShift);

            sql.execSQL("Insert into shift values('"+startDate+"','"+endDate+"',"+interestedInt+","
                                  +bookedShiftInt+","+absenceRequestInt+","+availableShiftInt+");");
    }
    }

    }
}
