package com.example.leand.tig164_beardeddragon.CheckIn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import java.util.Objects;
import com.example.leand.tig164_beardeddragon.CheckIn.CheckInTime;
import com.example.leand.tig164_beardeddragon.MainActivity;
import com.example.leand.tig164_beardeddragon.R;

/**
 * Created by leand on 2016-05-03.
 */
public class CheckInActivity extends AppCompatActivity{

    private Button openMainBtn;
    private Switch checkInSW;
    private Switch takeBreakSW;
    private boolean btnChecker;
    private TextView checkInLogTV;

    //Sets functionality for back button
    View.OnClickListener backToMainOnClickListener = new View.OnClickListener() {
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
        }
    };

    // Gives break-switch functionality
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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        checkInLogTV = (TextView) findViewById(R.id.check_in_log_tv);
        checkInLogTV.setText(CheckInTime.getLogString());

        // Connects back button to xml and assigns listener
        openMainBtn = (Button) findViewById(R.id.check_in_btn_to_main);
        assert openMainBtn != null;
        openMainBtn.setOnClickListener(backToMainOnClickListener);

        // Connects check in switch to xml and assigns listener
        checkInSW = (Switch) findViewById(R.id.check_in_swBtn_checkIn);
        assert checkInSW != null;
        checkInSW.setOnClickListener(checkInOnClickListener);

        // Connects break switch to xml and assigns listener
        takeBreakSW = (Switch) findViewById(R.id.check_in_swBtn_break);
        //takeBreakSW.setEnabled(false);
        assert takeBreakSW != null;
        takeBreakSW.setOnClickListener(takeBreakOnClickListener);
    }
}
