package com.example.leand.tig164_beardeddragon.Contacts;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.leand.tig164_beardeddragon.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContactsActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
/*        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition),
                        Toast.LENGTH_SHORT).show();
            }
        });
*/
/*        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition),
                        Toast.LENGTH_SHORT).show();

            }
        });
*/
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override


            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                String text = expandableListDetail.get(expandableListTitle.get(groupPosition)).get(childPosition);

                if(text.matches("[0-9]+") && text.length() > 2){
                    String uri = "tel: " + text.trim() ;
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(uri));
                    startActivity(intent);
                }

                else if(text.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
                    Intent it = new Intent(Intent.ACTION_SEND_MULTIPLE);
                    it.putExtra(Intent.EXTRA_EMAIL, text);
                    it.setType("message/rfc822");
                    startActivity(it);
                }

                else{
                    String url = "https://www.messenger.com/t/" + text;
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }

                /*else {
                    Toast.makeText(getApplicationContext(), "Could not connect to application", Toast.LENGTH_SHORT).show();
                }*/

                return false;
            }
        });

    }

}