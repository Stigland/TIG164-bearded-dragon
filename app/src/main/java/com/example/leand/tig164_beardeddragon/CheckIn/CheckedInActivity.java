package com.example.leand.tig164_beardeddragon.CheckIn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import com.example.leand.tig164_beardeddragon.R;

/**
 * Created by anton on 2016-05-17.
 */
public class CheckedInActivity extends AppCompatActivity{

    private Button takeBreakBtn;
    private Button ViewLogBtn;
    private Button checkOutBtn;
    private TextView checkedInTitle;
    private boolean onBreak;

    View.OnClickListener takeBreakOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(checkedInTitle.getText() == "You are on a break!") {
                checkedInTitle.setText("Welcome back to work!");
                CheckInTime.addToLogString(CheckInTime.getFineAssTime(false, false));
                onBreak = false;
            }else{
                onBreak = true;
                checkedInTitle.setText("You are on a break!");
                CheckInTime.addToLogString(CheckInTime.getFineAssTime(false, true));
            }
        }
    };

    View.OnClickListener checkOutOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getBaseContext(), CheckInActivity.class);
            startActivity(i);
            finish();
        }
    };

    View.OnClickListener viewLogOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent i = new Intent(getBaseContext(), CheckedInLogActivity.class);
            startActivity(i);
            //finish();
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checked_in);

        checkedInTitle = (TextView) findViewById(R.id.checked_in_title);

        if(!onBreak) {
            checkedInTitle.setText("You are checked in and ready to work!");
        }

        // Connects check in switch to xml and assigns listener
        takeBreakBtn = (Button) findViewById(R.id.take_break_btn);
        assert takeBreakBtn != null;
        takeBreakBtn.setOnClickListener(takeBreakOnClickListener);

        checkOutBtn = (Button) findViewById(R.id.check_out_btn);
        assert checkOutBtn != null;
        checkOutBtn.setOnClickListener(checkOutOnClickListener);

        // Connects break switch to xml and assigns listener
        ViewLogBtn = (Button) findViewById(R.id.view_log_btn);
        //takeBreakSW.setEnabled(false);
        assert ViewLogBtn != null;
        ViewLogBtn.setOnClickListener(viewLogOnClickListener);

        //checkedInLogTV.setText(CheckInTime.getLogString());
    }
}

