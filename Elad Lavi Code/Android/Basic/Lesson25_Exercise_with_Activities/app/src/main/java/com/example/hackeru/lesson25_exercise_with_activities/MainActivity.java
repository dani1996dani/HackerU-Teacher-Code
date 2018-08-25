package com.example.hackeru.lesson25_exercise_with_activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    public static final String TO = "to";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void goTo(int to){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(TO, to);
        startActivity(intent);
    }

    public void btnGoToSecond(View view) {
        goTo(2);
    }

    public void btnGoToThird(View view) {
        goTo(3);
    }
}
