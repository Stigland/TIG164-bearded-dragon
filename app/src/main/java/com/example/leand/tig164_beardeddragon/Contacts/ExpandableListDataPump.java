package com.example.leand.tig164_beardeddragon.Contacts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by edvin on 2016-05-05.
 */
public class ExpandableListDataPump {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List <Contact> contacts = fetchFromDB();

        for (Contact c: contacts) {
            List<String> cl = new ArrayList <String>();
            cl.add (c.getPhone());
            cl.add (c.getEmail());
            cl.add (c.getMessengerURI());
            expandableListDetail.put(c.getName(), cl);

        }

        return expandableListDetail;

    }

    private static List <Contact> fetchFromDB (){

        List <Contact> cl = new ArrayList<Contact>();

        cl.add (new Contact(1234, "Edvin Stigland", "edvin@sitlgnad.se", "edvinstigland", "0730502103"));
        cl.add (new Contact(1234, "Edvin Stigland1", "edvin@sitlgnad.se", "edvinstigland", "0730502103"));
        cl.add (new Contact(1234, "Edvin Stigland2", "edvin@sitlgnad.se", "edvinstigland", "0730502103"));
        cl.add (new Contact(1234, "Edvin Stigland3", "edvin@sitlgnad.se", "edvinstigland", "0730502103"));
        cl.add (new Contact(1234, "Edvin Stigland4", "edvin@sitlgnad.se", "edvinstigland", "0730502103"));

        return cl;

    }

}