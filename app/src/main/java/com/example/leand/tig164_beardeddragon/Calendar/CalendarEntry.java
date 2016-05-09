package com.example.leand.tig164_beardeddragon.Calendar;

import java.util.Date;

/**
 * Created by leand on 2016-05-09.
 */
public class CalendarEntry {

    private Date startDate;
    private Date endDate;
    private boolean interested;
    private boolean availableShift; //This variable should be set by employer. For this example it's stored in this class.
    private boolean bookedshift;
    private boolean absenceRequest;

    private CalendarEntry (Date startDate,Date endDate, boolean interested,
                           boolean availableShift, boolean bookedshift, boolean absenceRequest) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.interested = interested;
        this.availableShift = availableShift;
        this.bookedshift = bookedshift;
        this.absenceRequest = absenceRequest;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
        return bookedshift;
    }

    public void setBookedshift(boolean bookedshift) {
        this.bookedshift = bookedshift;
    }

    public boolean isAbsenceRequest() {
        return absenceRequest;
    }

    public void setAbsenceRequest(boolean absenceRequest) {
        this.absenceRequest = absenceRequest;
    }
}
