package com.example.leand.tig164_beardeddragon.Calendar;

import com.example.leand.tig164_beardeddragon.Calendar.CalendarEntry;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Date;

/**
 * Created by edvin on 2016-05-12.
 */
public class CalendarDataPump {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        //List <CalendarEntry> ce = fetchFromDB();
        List <CalendarEntry> ce2 = new ArrayList<CalendarEntry>();


        for (CalendarEntry c: ce2) {
            List<Object> cl = new ArrayList <Object>();
            cl.add (c.getStartDate());
            cl.add (c.getEndDate());
            cl.add (c.isInterested());
            cl.add (c.isAvailableShift());
            cl.add (c.isBookedshift());
            cl.add (c.isAbsenceRequest());

        }

        return expandableListDetail;

    }

    //private static List <CalendarEntry> fetchFromDB (){

        //List <CalendarEntry> ce = new ArrayList<Contact>();

        //return ce;

    //}

}