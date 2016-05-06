package com.example.leand.tig164_beardeddragon.Calendar;

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

import java.util.Calendar;
import java.util.Date;

/**
 * Created by leand on 2016-05-03.
 */

public class CalendarActivity extends AppCompatActivity {

    private Calendar cal = Calendar.getInstance();
    ColorDrawable lightBlue = new ColorDrawable(getResources().getColor(R.color.lightBlue));
    ColorDrawable lightGreen = new ColorDrawable(getResources().getColor(R.color.lightGreen));
    ColorDrawable yellow = new ColorDrawable(getResources().getColor(R.color.yellow));
    ColorDrawable orange = new ColorDrawable(getResources().getColor(R.color.orange));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        initiateCalendar();
    }

    private void initiateCalendar() {
        final CaldroidFragment caldroidFragment = new CaldroidFragment();
        Bundle args = new Bundle();

        args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
        caldroidFragment.setArguments(args);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.calendar1, caldroidFragment);
        ft.commit();

        final CaldroidListener listener = new CaldroidListener() {

            @Override
            public void onSelectDate(Date date, View view) {
                final Date blueDate = cal.getTime();
                ColorDrawable blue = new ColorDrawable(Color.BLUE);
                caldroidFragment.setBackgroundDrawableForDate(blue, date);

                caldroidFragment.refreshView();
            }
        };

        caldroidFragment.setCaldroidListener(listener);

    }
}
