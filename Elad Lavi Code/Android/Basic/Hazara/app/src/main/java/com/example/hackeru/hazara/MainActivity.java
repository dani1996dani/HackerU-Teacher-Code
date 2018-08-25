package com.example.hackeru.hazara;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    public static final String JUMP_TO_THIRD = "jump to third"; //we use this in Second activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSecond(View v) {
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }

    public void goToThird(View v) {
        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra(JUMP_TO_THIRD, true); //tell second activity to start third activity
        startActivity(i);
    }
}
