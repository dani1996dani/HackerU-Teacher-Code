package com.example.hackeru.lesson25_exercise_with_activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static com.example.hackeru.lesson25_exercise_with_activities.MainActivity.TO;

public class ThirdActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    private void goTo(int to){
        Intent data = new Intent();
        data.putExtra(TO, to);
        setResult(RESULT_OK, data);
        finish();
    }

    public void btnGoToMain(View view) {
        goTo(1);
    }

    public void btnGoToSecond(View view) {
        goTo(2);
    }
}
