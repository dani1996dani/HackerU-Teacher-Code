package com.example.hackeru.lesson27;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class MainActivity extends Activity {

    private String[] cityNames = {"Tel Aviv", "Ramat Gan", "Givaataim", "Ra'anana", "Tel Mond",
        "Kfar Bloom", "Nesher", "Tveria", "Be'er Sheva", "Gan Yavne", "Ashdod", "Jerusalem",
            "Katsrin", "Haifa", "Hadera", "Or Akiva", "Kiriat Shmona", "Naharya", "Lod", "Ashkelon",
        "Eilat", "Natanya"};
    private City[] cities;

    static class City{
        int cityId;
        String name;

        public City(int cityId, String name) {
            this.cityId = cityId;
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }


    private ArrayAdapter<City> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        cities = new City[cityNames.length];
        for (int i = 0; i < cities.length; i++) {
            cities[i] = new City(i, cityNames[i]);
        }

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, cities);
        AutoCompleteTextView textView = findViewById(R.id.txtCity);
        textView.setThreshold(3);
        textView.setAdapter(adapter);


        //TextView lblTest = findViewById(R.id.lblTest);
        //lblTest.setBackgroundColor(getResources().getColor(R.color.batata, null));
        //lblTest.setBackgroundResource(R.color.batata);

        textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("Elad", "i="+i+", l="+l);
                City city = adapter.getItem(i);
            }
        });
    }
}
