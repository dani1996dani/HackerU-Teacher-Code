package com.example.hackeru.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;

public class MainActivity extends Activity {

    public static final String AGE = "age";
    public static final String NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






    }

    public void btnGoToSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

        Bundle extras = new Bundle();
        extras.putInt(AGE, 37);
        extras.putString(NAME, "Elad");
        intent.putExtras(extras);
        //intent.putExtra(AGE, 37);
        //intent.putExtra(NAME, "Elad");
        //Intent intent = new Intent("MY_ACTION");

        startActivity(Intent.createChooser(intent, "second activity"));
    }
}
