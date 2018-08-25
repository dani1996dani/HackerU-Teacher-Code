package com.example.hackeru.lesson25_passing_objects;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import static com.example.hackeru.lesson25_passing_objects.Dog.AGE;
import static com.example.hackeru.lesson25_passing_objects.Dog.NAME;
import static com.example.hackeru.lesson25_passing_objects.MainActivity.DOG;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Method I:
        //String name = getIntent().getStringExtra(NAME);
        //int age = getIntent().getIntExtra(AGE, 0);
        //Dog d = new Dog(name, age);

        //Method II:
        //Dog d = new Dog(getIntent().getStringExtra(DOG));


        //Method III:
        //Dog d = new Dog(getIntent().getByteArrayExtra(DOG));

        //Method IV:
        Dog d = (Dog) getIntent().getSerializableExtra(DOG);


        //Toast.makeText(this, "dog: " + d, Toast.LENGTH_LONG).show();
        //Log.d("Elad", "dog: " + d);


    }
}
