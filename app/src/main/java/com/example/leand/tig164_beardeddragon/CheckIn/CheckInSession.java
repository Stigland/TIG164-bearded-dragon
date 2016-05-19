package com.example.leand.tig164_beardeddragon.CheckIn;

import com.example.leand.tig164_beardeddragon.R;

/**
 * Created by Anton on 2016-05-18.
 */
public class CheckInSession {

    public boolean checkedIn;
    public boolean onBreak;

    public CheckInSession(){
        checkedIn = false;
        onBreak   = false;
    }

    public CheckInSession(CheckInSession c){
        checkedIn = c.checkedIn;
        onBreak = c.onBreak;
    }

    public void checkIn(){
        checkedIn = true;
        CheckInTime.addToLogString(CheckInTime.getFineAssTime(true, checkedIn));
        //CheckedInActivity.checkedInTitle.setText("You are checked in and ready to work");
    }

    public void checkOut(){
        checkedIn = false;
        CheckInTime.addToLogString(CheckInTime.getFineAssTime(true, checkedIn));
    }

    public void takeBreak(){
        onBreak = true;
        CheckInTime.addToLogString(CheckInTime.getFineAssTime(false, onBreak));
       // CheckedInActivity.checkedInTitle.setText(R.string.checked_in_on_break);
    }

    public void stopBreak(){
        onBreak = false;
        CheckInTime.addToLogString(CheckInTime.getFineAssTime(false, onBreak));
       // CheckedInActivity.checkedInTitle.setText(R.string.checked_in_off_break);
    }
}
