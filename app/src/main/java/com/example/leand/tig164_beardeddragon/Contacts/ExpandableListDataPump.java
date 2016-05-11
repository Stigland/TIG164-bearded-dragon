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

        cl.add (new Contact(1234, "Edvin Stigland", "edvin@stigland.se", "edvinstigland", "0730502103"));
        cl.add (new Contact(1234, "Johannes Leander", "johannes@leander.se", "johannesleander", "0760506067"));
        cl.add (new Contact(1234, "Anton Wahlberg", "anton@wahlberg.se", "antonwahlberg", "0707564321"));
        cl.add (new Contact(1234, "Mikaela Holmer", "mikaela@holmer.se", "mikaelaholmer", "0720896745"));

        return cl;

    }

}