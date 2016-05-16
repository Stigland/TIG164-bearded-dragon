package com.example.leand.tig164_beardeddragon.Calendar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
    final CaldroidFragment caldroidFragment = new CaldroidFragment();
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private LinearLayout linearLayout;

    private Button setInterestedBtn;
    private Button rmInterestedBtn;
    private Button setAbsenceBtn;
    private Button rmAbsenceBtn;
    private Button grabShiftBtn;
    private TextView dateTv;
    private TextView statusTv;

    Date oldDate = new Date();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        linearLayout = (LinearLayout) findViewById(R.id.calendar_main_layout);

        initiateCalendar(caldroidFragment);

        updateCalendarStatuses(CalendarDataPump.fetchFromDB());

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



         final CaldroidListener listener = new CaldroidListener() {

            @Override
            public void onSelectDate(Date date, View view) {
                caldroidFragment.clearBackgroundDrawableForDate(oldDate);
                updateCalendarStatuses(CalendarDataPump.fetchFromDB());
                ColorDrawable selectionBlue = new ColorDrawable(getResources().getColor(R.color.backgroundBlue));
                caldroidFragment.setBackgroundDrawableForDate(selectionBlue, date);
                oldDate = date;


                //initPopup(date);
                caldroidFragment.refreshView();

                startActivity(new Intent(CalendarActivity.this,CalendarPopupActivity.class));



            }
        };
        caldroidFragment.setCaldroidListener(listener);
    }

    //Updates calendar statuses in calendar based on existing DB records
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

    private void initPopup(Date date){
        setInterestedBtn = (Button)  findViewById(R.id.calendar_popup_set_interested_btn);
        rmInterestedBtn  = (Button)  findViewById(R.id.calendar_popup_rm_interested_btn);
        setAbsenceBtn    = (Button)  findViewById(R.id.calendar_popup_set_absence_btn);
        rmAbsenceBtn     = (Button)  findViewById(R.id.calendar_popup_rm_absence_btn);
        grabShiftBtn     = (Button)  findViewById(R.id.calendar_popup_grab_shift_btn);
        dateTv           = (TextView)findViewById(R.id.calendar_popup_date_tv);
        statusTv         = (TextView)findViewById(R.id.calendar_popup_status_tv);

        layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.calendar_popup, null);

        popupWindow = new PopupWindow(container,500,500,true);
        popupWindow.showAtLocation(linearLayout, Gravity.CENTER,0,0);

        //dateTv.setText(CalendarEntryFunctionality.dateToString(date));

        popupWindow.isTouchable();
        popupWindow.setOutsideTouchable(true);


        container.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                popupWindow.dismiss();
                return true;
            }
        });

        //set user as available
        View.OnClickListener setInterestedOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(CalendarActivity.this);
                        builder.setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("")
                        .setMessage("Are you sure your status should be set to 'available'?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }

                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        };
        setInterestedBtn.setOnClickListener(setInterestedOnClickListener);

        //remove users availability
        View.OnClickListener rmInterestedOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(CalendarActivity.this);
                        builder.setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("")
                        .setMessage("Are you certain your status should be set to 'not available'?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        };
        rmInterestedBtn.setOnClickListener(rmInterestedOnClickListener);

        //let user request absence
        View.OnClickListener setAbsenceOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CalendarActivity.this);
                        builder.setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("")
                        .setMessage("Are you sure you want to request absence?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        };
        setAbsenceBtn.setOnClickListener(setAbsenceOnClickListener);

        //let user remove absence request
        View.OnClickListener rmAbsenceOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CalendarActivity.this);
                        builder.setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("")
                        .setMessage("Are you sure you want to remove your absence request?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        };
        rmAbsenceBtn.setOnClickListener(rmAbsenceOnClickListener);

        //grab shift, if available
        View.OnClickListener grabShiftOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CalendarActivity.this);
                        builder.setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("")
                        .setMessage("There is a shift available. Do you want to grab it??")
                        .setPositiveButton("Heck Yeah!", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("Nope", null)
                        .show();
            }
        };
        grabShiftBtn.setOnClickListener(grabShiftOnClickListener);
    }
}
