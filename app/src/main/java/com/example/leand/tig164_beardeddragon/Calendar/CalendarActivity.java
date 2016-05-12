package com.example.leand.tig164_beardeddragon.Calendar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.leand.tig164_beardeddragon.R;
import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import hirondelle.date4j.DateTime;

/**
 * Created by leand on 2016-05-03.
 */

public class CalendarActivity extends AppCompatActivity {

    private Calendar cal = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        SQLiteDatabase sqLiteDatabase = getBaseContext().openOrCreateDatabase("calendar_entries.db",MODE_PRIVATE, null);

        initiateCalendar();


       // CalendarEntryDatabase.createDB(sqLiteDatabase);
       // testDB(sqLiteDatabase);
    }

    private void initiateCalendar() {
        final CaldroidFragment caldroidFragment = new CaldroidFragment();
        Bundle args = new Bundle();

        args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
        args.putInt(CaldroidFragment.START_DAY_OF_WEEK, CaldroidFragment.MONDAY);
        caldroidFragment.setArguments(args);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.calendar1, caldroidFragment);
        ft.commit();



        final CaldroidListener listener = new CaldroidListener() {

            @Override
            public void onSelectDate(Date date, View view) {
                //ColorDrawable lightBlue = new ColorDrawable(getResources().getColor(R.color.orange));
                //caldroidFragment.setBackgroundDrawableForDate(lightBlue, date);


                caldroidFragment.refreshView();
            }
        };
        caldroidFragment.setCaldroidListener(listener);
    }

    protected void testDB(SQLiteDatabase sqLiteDatabase) {
        Cursor query = sqLiteDatabase.rawQuery("select * from shift", null);
        if(query.moveToFirst()) {
            do {
                //cycle through all records
                int shift_id = query.getInt(0);
                String start_time = query.getString(1);
                String end_time = query.getString(2);
                Toast.makeText(getBaseContext(), "Name= " + shift_id + ", phone= " + start_time + ", email= " + end_time, Toast.LENGTH_LONG).show();
            } while(query.moveToNext());
        } else {
            Toast.makeText(getBaseContext(),"Error retrieving data",Toast.LENGTH_SHORT).show();
        };
    }

    protected void updateCalendarCells() {
       // HashMap<Date, Drawable> map,

    }
}
