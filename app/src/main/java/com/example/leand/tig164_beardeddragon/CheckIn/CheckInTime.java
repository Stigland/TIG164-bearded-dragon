package com.example.leand.tig164_beardeddragon.CheckIn;

import com.example.leand.tig164_beardeddragon.Calendar.CalendarDataPump;
import com.example.leand.tig164_beardeddragon.Calendar.CalendarEntry;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by anton on 2016-05-05.
 */

public class CheckInTime {

    private static String logString;
    private static Calendar rightNow;

    public static void addToLogString(String s) {
        if (logString == null) {
            logString = "" + s;
        }else{
            logString = logString + s;
        }
    }

    public static String getLogString(){
        if (logString == null) {
            logString = "";
        }
        return logString;
    }

    public static void clearLogString(){
        logString = "";
    }

    public static void nullifyLogString(){ logString = null; }

    public static void getPassHours(){

    }

    /*public void setCheckInTime(long currentTime){
        // TODO add code for database editing
    }

    public void setCheckOutTime(long currentTime){
        // TODO add code for database editing
    }*/

    public static String getFineAssTime(boolean checkOrBreak, boolean inOrOut){

        rightNow = new GregorianCalendar(TimeZone.getDefault());
        rightNow.setTimeInMillis(System.currentTimeMillis());

        int[] rawTime     = {rightNow.get(Calendar.HOUR), rightNow.get(Calendar.MINUTE),
                             rightNow.get(Calendar.SECOND)};
        String[] fineTime = new String[3];
        int s = 0;

        for(int i: rawTime){
            if (i < 10){
                fineTime[s] = "0" + i + ":";
                s++;
            }else{
                fineTime[s] = i + ":";
                s++;
            }
        }

        if(checkOrBreak){
            if(inOrOut){
                return fineTime[0] + fineTime[1] + fineTime[2] + " Checked in\n";
            }else{
                return fineTime[0] + fineTime[1] + fineTime[2] + " Checked out\n";
            }
        }else{
            if(inOrOut){
                return fineTime[0] + fineTime[1] + fineTime[2] + " Took break\n";
            }else{
                return fineTime[0] + fineTime[1] + fineTime[2] + " Back from break\n";
            }
        }
    }

    //public String getScheduleHours(){

    //}
}