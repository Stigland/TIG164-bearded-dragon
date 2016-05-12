package com.example.leand.tig164_beardeddragon.Calendar;

import java.util.Date;
import java.util.GregorianCalendar;

import hirondelle.date4j.DateTime;

/**
 * Created by leand on 2016-05-09.
 */
public class CalendarEntry {

    public String startDate;
    public String endDate;
    public boolean interested;
    public boolean availableShift; //This variable should be set by employer. For this example it's stored in this class.
    public boolean bookedShift;
    public boolean absenceRequest;

    public CalendarEntry (String startDate,String endDate, boolean interested,
                           boolean availableShift, boolean bookedshift, boolean absenceRequest) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.interested = interested;
        this.availableShift = availableShift;
        this.bookedShift = bookedshift;
        this.absenceRequest = absenceRequest;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isInterested() {
        return interested;
    }

    public void setInterested(boolean interested) {
        this.interested = interested;
    }

    public boolean isAvailableShift() {
        return availableShift;
    }

    public void setAvailableShift(boolean availableShift) {
        this.availableShift = availableShift;
    }

    public boolean isBookedshift() {
        return bookedShift;
    }

    public void setBookedshift(boolean bookedshift) {
        this.bookedShift = bookedshift;
    }

    public boolean isAbsenceRequest() {
        return absenceRequest;
    }

    public void setAbsenceRequest(boolean absenceRequest) {
        this.absenceRequest = absenceRequest;
    }
}
