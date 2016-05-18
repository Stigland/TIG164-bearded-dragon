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
public class CheckInActivity extends AppCompatActivity{

    private Button openMainBtn;
    private Button checkInBtn;
    private TextView workPassTimes;
    //private Switch takeBreakSW;
    //private boolean btnChecker;
    //private TextView checkInLogTV;

    //Sets functionality for back button
    View.OnClickListener openMainOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getBaseContext(), MainActivity.class);
            startActivity(i);
            //finish();
        }
    };

    // Gives check-in-switch functionality
    View.OnClickListener checkInOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            CheckInTime.addToLogString(CheckInTime.getFineAssTime(true, true));
            Intent i = new Intent(getBaseContext(), CheckedInActivity.class);
            startActivity(i);
            finish();
            /*
            btnChecker = checkInSW.isChecked();
            if(btnChecker){
                takeBreakSW.setEnabled(true);
                checkInLogTV.setText(CheckInTime.addToLogString(
                                     CheckInTime.getFineAssTime(true, true)));
            }else{
                takeBreakSW.setChecked(false);
                takeBreakSW.setEnabled(false);
                checkInLogTV.setText(CheckInTime.addToLogString(
                                     CheckInTime.getFineAssTime(true, false)));
            }
            */
        }
    };

    /* Gives break-switch functionality
    View.OnClickListener takeBreakOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            btnChecker = takeBreakSW.isChecked();
            if(btnChecker){
                checkInSW.setEnabled(false);
                checkInLogTV.setText(CheckInTime.addToLogString(
                                     CheckInTime.getFineAssTime(false, true)));
            }else{
                checkInSW.setEnabled(true);
                checkInLogTV.setText(CheckInTime.addToLogString(
                                     CheckInTime.getFineAssTime(false, false)));
            }
        }
    };
    */

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        //checkInLogTV = (TextView) findViewById(R.id.check_in_log_tv);

        openMainBtn = (Button) findViewById(R.id.open_main_btn);
        assert openMainBtn != null;
        openMainBtn.setOnClickListener(openMainOnClickListener);

        // Connects check in switch to xml and assigns listener
        checkInBtn = (Button) findViewById(R.id.check_in_btn);
        assert checkInBtn != null;
        checkInBtn.setOnClickListener(checkInOnClickListener);

        /* Connects break switch to xml and assigns listener
        takeBreakSW = (Switch) findViewById(R.id.check_in_swBtn_break);
        //takeBreakSW.setEnabled(false);
        assert takeBreakSW != null;
        takeBreakSW.setOnClickListener(takeBreakOnClickListener);
        checkInLogTV.setText(CheckInTime.getLogString());
        */
    }
}

