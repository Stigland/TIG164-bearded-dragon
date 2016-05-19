package com.example.leand.tig164_beardeddragon;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.leand.tig164_beardeddragon.Calendar.CalendarActivity;
import com.example.leand.tig164_beardeddragon.Calendar.CalendarEntryDatabase;
import com.example.leand.tig164_beardeddragon.CheckIn.CheckInActivity;
import com.example.leand.tig164_beardeddragon.CheckIn.CheckedInActivity;
import com.example.leand.tig164_beardeddragon.Contacts.ContactsActivity;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button OpenCalendarBtn;
    private Button OpenContactsBtn;
    private Button OpenCheckInBtn;
    private TextView calendarTv;
    private TextView contactsTv;
    private TextView checkInTv;
    public static SQLiteDatabase sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sql = getBaseContext().openOrCreateDatabase("test1.db",MODE_PRIVATE, null);
        CalendarEntryDatabase.createDB(sql);

        OpenCalendarBtn   = (Button) findViewById(R.id.menu_OpenCalendar_Btn);
        OpenContactsBtn   = (Button) findViewById(R.id.menu_OpenContacts_Btn);
        OpenCheckInBtn    = (Button) findViewById(R.id.menu_OpenCheckIn_Btn);
        calendarTv        = (TextView)findViewById(R.id.calendar_tv);
        contactsTv        = (TextView)findViewById(R.id.contacts_tv);
        checkInTv         = (TextView)findViewById(R.id.check_in_tv);

        //Open Calendar
        View.OnClickListener openCalendarOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(), CalendarActivity.class);
                startActivity(i);

            }
        };
        OpenCalendarBtn.setOnClickListener(openCalendarOnClickListener);
        calendarTv.setOnClickListener(openCalendarOnClickListener);

        //Open Contacts
        View.OnClickListener openContactsOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ContactsActivity.class);
                startActivity(i);

            }
        };
        OpenContactsBtn.setOnClickListener(openContactsOnClickListener);
        contactsTv.setOnClickListener(openContactsOnClickListener);

        //Open Check In
        View.OnClickListener openCheckInOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(CheckInActivity.currentUser != null && CheckInActivity.currentUser.checkedIn){
                   Intent i = new Intent(getBaseContext(), CheckedInActivity.class);
                   startActivity(i);
               }else{
                   Intent i = new Intent(getBaseContext(), CheckInActivity.class);
                   startActivity(i);
               }
            }
        };
        OpenCheckInBtn.setOnClickListener(openCheckInOnClickListener);
        checkInTv.setOnClickListener(openCheckInOnClickListener);

    }
}
