package com.example.hackeru.lesson25_exercise_with_activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static com.example.hackeru.lesson25_exercise_with_activities.MainActivity.TO;

public class SecondActivity extends Activity {

    public static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        handleGoToIntent(getIntent());
    }

    private void goTo(int to){
        switch (to){
            case 1:
                finish();
                break;
            case 2:
                return;
            case 3:
                Intent intent = new Intent(this, ThirdActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
        }
    }

    private void handleGoToIntent(Intent intent){
        int to = intent.getIntExtra(TO, 0);
        goTo(to);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            handleGoToIntent(data);
        }
    }

    public void btnGoToMain(View view) {
        goTo(1);
    }

    public void btnGoToThird(View view) {
        goTo(3);
    }
}
