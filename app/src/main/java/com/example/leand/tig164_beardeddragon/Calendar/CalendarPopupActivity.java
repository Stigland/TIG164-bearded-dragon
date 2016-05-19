package com.example.leand.tig164_beardeddragon.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leand.tig164_beardeddragon.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by leand on 2016-05-16.
 */
public class CalendarPopupActivity extends Activity {

    private Button setInterestedBtn;
    private Button rmInterestedBtn;
    private Button setAbsenceBtn;
    private Button rmAbsenceBtn;
    private Button grabShiftBtn;
    private String stringDate;
    private TextView dateTv;
    private TextView statusTv;
    private CalendarEntry workingCe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_popup);

        setInterestedBtn = (Button)  findViewById(R.id.calendar_popup_set_interested_btn);
        rmInterestedBtn  = (Button)  findViewById(R.id.calendar_popup_rm_interested_btn);
        setAbsenceBtn    = (Button)  findViewById(R.id.calendar_popup_set_absence_btn);
        rmAbsenceBtn     = (Button)  findViewById(R.id.calendar_popup_rm_absence_btn);
        grabShiftBtn     = (Button)  findViewById(R.id.calendar_popup_grab_shift_btn);
        dateTv           = (TextView)findViewById(R.id.calendar_popup_date_tv);
        statusTv         = (TextView)findViewById(R.id.calendar_popup_status_tv);
        stringDate       = CalendarEntryFunctionality.dateToDayString(CalendarActivity.getOldDate());

        //Resizes activity window
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.5), (int)(width*.34));

        //Basic initialization of popup
        dateTv.setText(stringDate);
        workingCe = initPopupButtons(CalendarActivity.getOldDate());

        //set user as available
        View.OnClickListener setInterestedOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(CalendarPopupActivity.this);
                builder.setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("")
                    .setMessage("Are you sure your status should be set to 'available'?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(!workingCe.interested) {
                                workingCe.setInterested(true);
                                //CalendarActivity.updateCalendar();
                                Toast.makeText(getBaseContext(),"Status updated to 'available'",Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getBaseContext(),"Something went wrong",Toast.LENGTH_LONG).show();
                            }
                            CalendarActivity.caldroidFragment.refreshView();
                            finish();
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

                AlertDialog.Builder builder = new AlertDialog.Builder(CalendarPopupActivity.this);
                builder.setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("")
                    .setMessage("Are you certain your status should be set to 'not available'?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getBaseContext(),"Status updated to 'not available'",Toast.LENGTH_SHORT).show();
                           // CalendarActivity.updateCalendar();
                            finish();
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
                AlertDialog.Builder builder = new AlertDialog.Builder(CalendarPopupActivity.this);
                builder.setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("")
                    .setMessage("Are you sure you want to request absence?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getBaseContext(),"Absence request has been registered",Toast.LENGTH_SHORT).show();
                            //CalendarActivity.updateCalendar();
                            finish();
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
                AlertDialog.Builder builder = new AlertDialog.Builder(CalendarPopupActivity.this);
                builder.setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("")
                    .setMessage("Are you sure you want to remove your absence request?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getBaseContext(),"Absence request has been removed",Toast.LENGTH_SHORT).show();
                            //CalendarActivity.updateCalendar();
                            finish();
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
                AlertDialog.Builder builder = new AlertDialog.Builder(CalendarPopupActivity.this);
                builder.setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("")
                    .setMessage("There is a shift available. Do you want to grab it?")
                    .setPositiveButton("Heck Yeah!", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getBaseContext(),"The shift is now yours",Toast.LENGTH_SHORT).show();
                            //CalendarActivity.updateCalendar();
                            finish();
                        }
                    })
                    .setNegativeButton("Nope", null)
                    .show();
            }
        };
        grabShiftBtn.setOnClickListener(grabShiftOnClickListener);
    }

    private CalendarEntry initPopupButtons(Date date) {
        List<CalendarEntry> ce = new ArrayList<CalendarEntry>();
        ce = CalendarDataPump.fetchFromDB();
        String dayString = CalendarEntryFunctionality.dateToDayString(date);
        String cDayString = "";
        int counter = 0;
        CalendarEntry chosenCe = new CalendarEntry(cDayString, cDayString, false, false, false ,false);

        setInterestedBtn.setVisibility(View.GONE);
        rmInterestedBtn.setVisibility(View.GONE);
        setAbsenceBtn.setVisibility(View.GONE);
        rmAbsenceBtn.setVisibility(View.GONE);
        grabShiftBtn.setVisibility(View.GONE);
        statusTv.setVisibility(View.GONE);


        //The ugliest hack of all time
        for (CalendarEntry c : ce) {
            cDayString = CalendarEntryFunctionality.dateToDayString(CalendarEntryFunctionality.stringToDate(c.startDate));
            chosenCe = c;
            if(dayString.equals(cDayString)) {
                counter++;
                if (c.interested) {
                    rmInterestedBtn.setVisibility(View.VISIBLE);
                } else if (c.availableShift) {
                    grabShiftBtn.setVisibility(View.VISIBLE);
                } else if (c.absenceRequest) {
                    rmAbsenceBtn.setVisibility(View.VISIBLE);
                } else if (c.bookedShift) {
                    setAbsenceBtn.setVisibility(View.VISIBLE);
                    statusTv.setVisibility(View.VISIBLE);
                    statusTv.setText("Start: " + CalendarEntryFunctionality.dateTotimeString(CalendarEntryFunctionality.stringToDate(c.startDate))
                                     + "\nEnd:  " + CalendarEntryFunctionality.dateTotimeString(CalendarEntryFunctionality.stringToDate(c.endDate)));
                } else {
                    counter--;
                }
                return c;
            }
        }
        if (counter<=0){
            setInterestedBtn.setVisibility(View.VISIBLE);

            chosenCe = new CalendarEntry(cDayString, cDayString, false, false, false ,false);
        }
        return chosenCe;
    }
}
