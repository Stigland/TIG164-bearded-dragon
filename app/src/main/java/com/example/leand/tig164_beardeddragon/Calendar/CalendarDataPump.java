package com.example.leand.tig164_beardeddragon.Calendar;

import com.example.leand.tig164_beardeddragon.Calendar.CalendarEntry;
import com.example.leand.tig164_beardeddragon.Contacts.Contact;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Date;

/**
 * Created by edvin on 2016-05-12.
 */
public class CalendarDataPump {

    public static HashMap<String, List<Object>> getData() {
        HashMap<String, List<Object>> dateInfo = new HashMap<String, List<Object>>();

        List <CalendarEntry> ce = fetchFromDB();
        List <CalendarEntry> ce2 = new ArrayList<CalendarEntry>();


        for (CalendarEntry c: ce2) {
            List<Object> cl = new ArrayList <Object>();
            cl.add (c.getStartDate());
            cl.add (c.getEndDate());
            cl.add (c.isInterested());
            cl.add (c.isAvailableShift());
            cl.add (c.isBookedshift());
            cl.add (c.isAbsenceRequest());
            dateInfo.put("Date", cl);


        }

        return dateInfo;

    }

    public static List <CalendarEntry> fetchFromDB (){

        List <CalendarEntry> ce = new ArrayList<CalendarEntry>();

        ce.add(new CalendarEntry("2016-05-02 06:30","2016-05-11 14:30", true, false, false, true ));
        ce.add(new CalendarEntry("2016-05-11 06:30","2016-05-11 14:30", true, false, false, false ));
        ce.add(new CalendarEntry("2016-05-12 06:30","2016-05-12 14:30", false, false, true, false ));
        ce.add(new CalendarEntry("2016-05-13 06:30","2016-05-13 14:30", false, false, true, false ));
        ce.add(new CalendarEntry("2016-05-27 06:30","2016-05-11 14:30", false, false, true, false ));
        ce.add(new CalendarEntry("2016-05-28 06:30","2016-05-11 14:30", true, false, false, false ));
        ce.add(new CalendarEntry("2016-05-01 06:30","2016-05-11 14:30", false, true, false, false ));
        ce.add(new CalendarEntry("2016-05-31 06:30","2016-05-11 14:30", true, false, false, false ));
        ce.add(new CalendarEntry("2016-06-01 06:30","2016-05-11 14:30", true, false, false, false ));
        ce.add(new CalendarEntry("2016-06-04 06:30","2016-05-11 14:30", true, false, false, false ));
        ce.add(new CalendarEntry("2016-06-05 06:30","2016-05-11 14:30", true, false, false, false ));



        return ce;

    }

}