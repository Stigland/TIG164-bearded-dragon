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
import java.util.List;

import hirondelle.date4j.DateTime;

/**
 * Created by leand on 2016-05-03.
 */

public class CalendarActivity extends AppCompatActivity {

    private Calendar cal = Calendar.getInstance();
    Date oldDate = new Date();
    final CaldroidFragment caldroidFragment = new CaldroidFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        initiateCalendar(caldroidFragment);

    }

    private void initiateCalendar(final CaldroidFragment caldroidFragment) {
        Bundle args = new Bundle();

        args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
        args.putInt(CaldroidFragment.START_DAY_OF_WEEK, CaldroidFragment.MONDAY);
        caldroidFragment.setArguments(args);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.calendar1, caldroidFragment);
        ft.commit();

        updateCalendarStatuses(CalendarDataPump.fetchFromDB());



         final CaldroidListener listener = new CaldroidListener() {

            @Override
            public void onSelectDate(Date date, View view) {
                caldroidFragment.clearBackgroundDrawableForDate(oldDate);
                updateCalendarStatuses(CalendarDataPump.fetchFromDB());
                ColorDrawable selectionBlue = new ColorDrawable(getResources().getColor(R.color.backgroundBlue));
                caldroidFragment.setBackgroundDrawableForDate(selectionBlue, date);
                oldDate = date;

                caldroidFragment.refreshView();

            }
        };
        caldroidFragment.setCaldroidListener(listener);
    }

    public void updateCalendarStatuses(List<CalendarEntry> ce){

        final ColorDrawable myShiftsGreen = new ColorDrawable(getResources().getColor(R.color.lightGreen));
        final ColorDrawable interestedYellow = new ColorDrawable(getResources().getColor(R.color.yellow));
        final ColorDrawable availableBlue = new ColorDrawable(getResources().getColor(R.color.lightBlue));
        final ColorDrawable absenceOrange = new ColorDrawable(getResources().getColor(R.color.orange));

        for (CalendarEntry c : ce)  {

            if (c.bookedShift) {
                caldroidFragment.setBackgroundDrawableForDate(myShiftsGreen, CalendarEntryFunctionality.stringToDate(c.startDate));
            } else if (c.absenceRequest) {
                caldroidFragment.setBackgroundDrawableForDate(absenceOrange, CalendarEntryFunctionality.stringToDate(c.startDate));
            } else if (c.availableShift){
                caldroidFragment.setBackgroundDrawableForDate(availableBlue, CalendarEntryFunctionality.stringToDate(c.startDate));
            } else if (c.interested){
                caldroidFragment.setBackgroundDrawableForDate(interestedYellow, CalendarEntryFunctionality.stringToDate(c.startDate));
            }
        }

    }
}
