package com.example.leand.tig164_beardeddragon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.content.Intent;
import android.widget.Button;
import android.widget.Switch;

/**
 * Created by anton on 2016-05-05.
 */

public class CheckInTime{

    public String logString;

    public CheckInTime(String s){
        logString = s;
    }

    public String addToLogString(String s){
        return logString + s;
    }

    public void setCheckInTime(long currentTime){
        // add code for database editing
    }

    public void setCheckOutTime(long currentTime){
        // add code for database editing
    }

    public String getTimeString(boolean inOrOut) {
        long currentTime = System.currentTimeMillis();
        String parsedTimeStamp = String.valueOf(currentTime);
        String firstTimeStamp = parsedTimeStamp.substring(0, 2);
        String secondTimeStamp = parsedTimeStamp.substring(2, 4);
        if(inOrOut) {
            return firstTimeStamp + ":" + secondTimeStamp + ": Checked in\n";
        }else{
            return firstTimeStamp + ":" + secondTimeStamp + ": Checked out\n";
        }
    }
}