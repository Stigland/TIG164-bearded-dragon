package com.example.leand.tig164_beardeddragon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.leand.tig164_beardeddragon.Calendar.CalendarActivity;
import com.example.leand.tig164_beardeddragon.CheckIn.CheckInActivity;
import com.example.leand.tig164_beardeddragon.Contacts.ContactsActivity;

public class MainActivity extends AppCompatActivity {

    private Button OpenCalendarBtn;
    private Button OpenContactsBtn;
    private Button OpenCheckInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OpenCalendarBtn   = (Button) findViewById(R.id.menu_OpenCalendar_Btn);
        OpenContactsBtn   = (Button) findViewById(R.id.menu_OpenContacts_Btn);
        OpenCheckInBtn    = (Button) findViewById(R.id.menu_OpenCheckIn_Btn);

        //Open Calendar
        View.OnClickListener openCalendarOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(getBaseContext(), CalendarActivity.class);
            startActivity(i);
            //finish();
            }
        };
        OpenCalendarBtn.setOnClickListener(openCalendarOnClickListener);

        //Open Contacts
        View.OnClickListener openContactsOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(getBaseContext(), ContactsActivity.class);
            startActivity(i);
            //finish();
            }
        };
        OpenContactsBtn.setOnClickListener(openContactsOnClickListener);

        //Open Check In
        View.OnClickListener openCheckInOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(getBaseContext(), CheckInActivity.class);
            startActivity(i);
            //finish();
            }
        };
        OpenCheckInBtn.setOnClickListener(openCheckInOnClickListener);
    }
}
