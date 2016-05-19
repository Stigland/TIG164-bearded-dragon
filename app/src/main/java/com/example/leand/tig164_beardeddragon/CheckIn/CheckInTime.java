package com.example.leand.tig164_beardeddragon.CheckIn;

import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.leand.tig164_beardeddragon.Calendar.CalendarActivity;
import com.example.leand.tig164_beardeddragon.Calendar.CalendarDataPump;
import com.example.leand.tig164_beardeddragon.Calendar.CalendarEntry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by anton on 2016-05-05.
 */

public class CheckInTime {

    private static String logString;
    private static Calendar rightNow;
    private static ArrayList<CalendarEntry> calendarEntries;
    private static ArrayList<String> conditions;
    private static boolean isWork;

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

    public static String getScheduleHours(){

        calendarEntries    = new ArrayList<>(CalendarDataPump.getDB());
        String startTime   = "";
        String endTime     = "";
        String currentDate = getCurrentDate();

            for ( CalendarEntry ce : calendarEntries) {
                isWork = ce.getStartDate().substring(0, 9).equalsIgnoreCase(currentDate);
                if(isWork && ce.isBookedshift()){
                    startTime = ce.getStartDate().substring(11, 15);
                    endTime = ce.getEndDate().substring(11, 15);
                }else if(isWork && ce.isAbsenceRequest()){
                    startTime = ce.getStartDate().substring(11, 15);
                    endTime = ce.getEndDate().substring(11, 15);
                }else if(isWork && ce.isAvailableShift()){
                    startTime = ce.getStartDate().substring(11, 15);
                    endTime = ce.getEndDate().substring(11, 15);
                }else if(isWork && ce.isAvailableShift()){
                    startTime = ce.getStartDate().substring(11, 15);
                    endTime = ce.getEndDate().substring(11, 15);
                }
            }

        if(!startTime.equals("")){
            return startTime + "-" + endTime;
        }else{
            return "DOBBY IS FREE";
        }
    }

    public static String getPassStatus(){
        calendarEntries     = new ArrayList<>(CalendarDataPump.getDB());
        String status       = "";
        String currentDate  = getCurrentDate();

        for ( CalendarEntry ce : calendarEntries) {
            isWork = ce.getStartDate().substring(0, 9).equalsIgnoreCase(currentDate);
            if(isWork && ce.isBookedshift()) {
                status = "You\'re booked for work at: ";
            }else if(isWork && ce.isAbsenceRequest()){
                status = "You've requested absence today at: ";
            }else if(isWork && ce.isAvailableShift()){
                status = "You're interested for work at: ";
            }else if(isWork && ce.isAvailableShift()){
                status = "There is work available today at: ";
            }
        }

        if(!status.equals("")) {
            return status;
        }else{
            return "Nothing is booked today";
        }
    }

    public static String getCurrentDate() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
        //return sdfDate.format(new Date());
    }
}