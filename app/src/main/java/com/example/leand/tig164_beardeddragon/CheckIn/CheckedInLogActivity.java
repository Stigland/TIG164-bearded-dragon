package com.example.leand.tig164_beardeddragon.CheckIn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.leand.tig164_beardeddragon.R;

/**
 * Created by anton on 2016-05-17.
 */
public class CheckedInLogActivity extends AppCompatActivity{

    private TextView logTV;

    @Override
    public void onBackPressed(){
        finish();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        logTV = (TextView) findViewById(R.id.schedule_log_tv);
        logTV.setText(CheckInTime.getLogString());
    }
}

