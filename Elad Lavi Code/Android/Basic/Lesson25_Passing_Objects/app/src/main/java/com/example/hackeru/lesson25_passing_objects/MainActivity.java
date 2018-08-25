package com.example.hackeru.lesson25_passing_objects;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import static com.example.hackeru.lesson25_passing_objects.Dog.AGE;
import static com.example.hackeru.lesson25_passing_objects.Dog.NAME;

public class MainActivity extends Activity {

    public static final String DOG = "dog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dog snoopy = new Dog("Snoopy", 5);
        Intent intent = new Intent(this, SecondActivity.class);
        //Method I:
        //intent.putExtra(NAME, snoopy.getName());
        //intent.putExtra(AGE, snoopy.getAge());

        //Method II:
        //intent.putExtra(DOG, snoopy.toJSON());

        //Method III:
        //intent.putExtra(DOG, snoopy.getBytes());
        //startActivity(intent);

        //Method IV:
        intent.putExtra(DOG, snoopy);

    }
}
