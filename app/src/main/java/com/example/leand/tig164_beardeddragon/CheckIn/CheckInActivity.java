package com.example.leand.tig164_beardeddragon.CheckIn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.example.leand.tig164_beardeddragon.MainActivity;
import com.example.leand.tig164_beardeddragon.R;

import org.w3c.dom.Text;

/**
 * Created by anton on 2016-05-03.
 */

/*
 * Toast.makeText(getApplicationContext, sdfDate.format(new Date()), Toast.LENGTH_LONG).show();
 */

public class CheckInActivity extends AppCompatActivity{

    private Button checkInBtn;
    private TextView workPassStatusTV;
    private TextView workPassTimeTV;
    public static CheckInSession currentUser;

    public void onBackPressed(){
        Intent i = new Intent(getBaseContext(), MainActivity.class);
        startActivity(i);
        finish();
    }

    // Gives check-in-switch functionality
    View.OnClickListener checkInOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent x = new Intent(getBaseContext(), CheckedInActivity.class);
            startActivity(x);
            currentUser.checkIn();
            finish();
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        if(CheckedInActivity.currentUser == null) {
            currentUser = new CheckInSession();
        }else if(CheckedInActivity.currentUser != null){
            currentUser = new CheckInSession(CheckedInActivity.currentUser);
        }

        workPassTimeTV   = (TextView) findViewById(R.id.schedule_time_tv);
        workPassStatusTV = (TextView) findViewById(R.id.check_in_title);
        workPassTimeTV.setText(CheckInTime.getScheduleHours());
        workPassStatusTV.setText(CheckInTime.getPassStatus());

        // Connects check in button to xml and assigns listener
        checkInBtn = (Button) findViewById(R.id.check_in_btn);
        assert checkInBtn != null;
        checkInBtn.setOnClickListener(checkInOnClickListener);
    }
}

