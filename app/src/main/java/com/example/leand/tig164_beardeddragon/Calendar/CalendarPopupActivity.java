package com.example.leand.tig164_beardeddragon.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.leand.tig164_beardeddragon.R;

import java.util.Date;

/**
 * Created by leand on 2016-05-16.
 */
public class CalendarPopupActivity extends Activity {

    private Button setInterestedBtn;
    private Button rmInterestedBtn;
    private Button setAbsenceBtn;
    private Button rmAbsenceBtn;
    private Button grabShiftBtn;

    public static TextView dateTv;
    private TextView statusTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.6), (int)(height*.6));
    }

}
