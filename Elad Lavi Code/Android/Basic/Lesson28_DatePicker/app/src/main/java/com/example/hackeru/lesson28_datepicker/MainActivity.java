package com.example.hackeru.lesson28_datepicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        //timePicker.setHour(43);
    }

    public void btnClickMe(View view) {
        String s = "";
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();
        if(hour < 10)
            s += "0";
        s += hour;
        s += ":";
        if(minute < 10)
            s += "0";
        s += minute;
        Toast.makeText(this, "time: " + s,
                Toast.LENGTH_LONG).show();
    }
}
