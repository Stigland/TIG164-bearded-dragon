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

        List<String> johannesLeander = new ArrayList<String>();
        johannesLeander.add("India");
        johannesLeander.add("Pakistan");
        johannesLeander.add("Australia");
        johannesLeander.add("England");
        johannesLeander.add("South Africa");

        List<String> football = new ArrayList<String>();
        football.add("Brazil");
        football.add("Spain");
        football.add("Germany");
        football.add("Netherlands");
        football.add("Italy");

        List<String> basketball = new ArrayList<String>();
        basketball.add("United States");
        basketball.add("Spain");
        basketball.add("Argentina");
        basketball.add("France");
        basketball.add("Russia");

        expandableListDetail.put("CRICKET TEAMS", johannesLeander);
        expandableListDetail.put("FOOTBALL TEAMS", football);
        expandableListDetail.put("BASKETBALL TEAMS", basketball);
        return expandableListDetail;
    }

}