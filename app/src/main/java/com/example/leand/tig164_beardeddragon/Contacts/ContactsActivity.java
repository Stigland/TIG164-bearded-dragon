package com.example.leand.tig164_beardeddragon.Contacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import com.example.leand.tig164_beardeddragon.R;

/**
 * Created by leand on 2016-05-03.
 */
public class ContactsActivity extends AppCompatActivity{

    private List<Contact> myContactList = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
    }
}
