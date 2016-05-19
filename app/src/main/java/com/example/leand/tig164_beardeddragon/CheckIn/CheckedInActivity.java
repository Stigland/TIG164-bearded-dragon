package com.example.leand.tig164_beardeddragon.CheckIn;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.example.leand.tig164_beardeddragon.MainActivity;
import com.example.leand.tig164_beardeddragon.R;

/**
 * Created by anton on 2016-05-17.
 */
public class CheckedInActivity extends AppCompatActivity{

    private Button takeBreakBtn;
    private Button ViewLogBtn;
    private Button checkOutBtn;
    protected static TextView checkedInTitle;
    public static CheckInSession currentUser;
    private static boolean gotOffFromBreak;

    @Override
    public void onBackPressed(){
        Intent i = new Intent(getBaseContext(), MainActivity.class);
        startActivity(i);
    }

    View.OnClickListener takeBreakOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(currentUser.onBreak) {
                currentUser.stopBreak();
                takeBreakBtn.setText(R.string.end_break_btn);
                gotOffFromBreak = true;
            }else{
                currentUser.takeBreak();
                takeBreakBtn.setText(R.string.start_break_btn);
                gotOffFromBreak = false;
            }
        }
    };

    View.OnClickListener checkOutOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(CheckedInActivity.this);
            builder.setTitle("Really check out?")
            .setMessage("Are you sure you want to check out for today?")
            .setNegativeButton(android.R.string.no, null)
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface arg0, int arg1) {
                    Intent i = new Intent(getBaseContext(), CheckInActivity.class);
                    startActivity(i);
                    currentUser.checkOut();
                }
            }).create().show();
        }
    };

    View.OnClickListener viewLogOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getBaseContext(), CheckedInLogActivity.class);
            startActivity(i);
        }
    };

    public static void setCheckedInTitle() {
        if(gotOffFromBreak) {
            CheckedInActivity.checkedInTitle.setText(R.string.checked_in_off_break);
        }else{
            if (currentUser.checkedIn && !currentUser.onBreak) {
                CheckedInActivity.checkedInTitle.setText(R.string.checked_in_title_text);
            } else if (currentUser.checkedIn && currentUser.onBreak) {
                CheckedInActivity.checkedInTitle.setText(R.string.checked_in_on_break);
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checked_in);

        checkedInTitle = (TextView) findViewById(R.id.checked_in_title);

        currentUser = new CheckInSession(CheckInActivity.currentUser);
        //currentUser.checkIn();

        // Connects check in switch to xml and assigns listener
        takeBreakBtn = (Button) findViewById(R.id.take_break_btn);
        assert takeBreakBtn != null;
        takeBreakBtn.setOnClickListener(takeBreakOnClickListener);

        checkOutBtn = (Button) findViewById(R.id.check_out_btn);
        assert checkOutBtn != null;
        checkOutBtn.setOnClickListener(checkOutOnClickListener);

        // Connects break switch to xml and assigns listener
        ViewLogBtn = (Button) findViewById(R.id.view_log_btn);
        assert ViewLogBtn != null;
        ViewLogBtn.setOnClickListener(viewLogOnClickListener);
    }
}

