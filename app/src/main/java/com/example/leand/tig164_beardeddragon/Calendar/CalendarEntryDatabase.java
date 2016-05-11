package com.example.leand.tig164_beardeddragon.Calendar;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by leand on 2016-05-10.
 */
public class CalendarEntryDatabase {

    public static void createDB(SQLiteDatabase sqLiteDatabase) {

        //Drops existing tables
        sqLiteDatabase.execSQL("DROP TABLE person");
        sqLiteDatabase.execSQL("DROP TABLE shift");
        sqLiteDatabase.execSQL("DROP TABLE day");

        //Creates columns in tables
        sqLiteDatabase.execSQL("CREATE TABLE person ( " +
                "person_id int PRIMARY_KEY NOT NULL," +
                "name string" +
                ");");
        sqLiteDatabase.execSQL("CREATE TABLE shift (" +
                "shift_id int PRIMARY_KEY NOT NULL," +
                "start_time Datetime," +
                "end_time Datetime," +
                "day_date Datetime FOREIGN_KEY," +
                "person_id FOREIGN_KEY," +
                "status int" +
                ");");
        sqLiteDatabase.execSQL("CREATE TABLE day (" +
                "day_date String PRIMARY_KEY" +
                ");");

        //Insert new values in DB
        sqLiteDatabase.execSQL("Insert into shift values(1,'13:00','20:00','May 9, 2016','Kalle', 2);");
        sqLiteDatabase.execSQL("Insert into shift values(2,'08:00','14:00','May 9, 2016','Anya', 0);");
        sqLiteDatabase.execSQL("Insert into shift values(3,'14:00','21:00','May 10, 2016','', 1);");

        sqLiteDatabase.execSQL("Insert into person values(1, 'Anya');");
        sqLiteDatabase.execSQL("Insert into person values(1, 'Kalle');");
        sqLiteDatabase.execSQL("Insert into person values(1, 'Bubba');");

        sqLiteDatabase.execSQL("Insert into day values('May 9, 2016');");
        sqLiteDatabase.execSQL("Insert into day values('May 10, 2016');");
        sqLiteDatabase.execSQL("Insert into day values('May 11, 2016');");
    }
}
