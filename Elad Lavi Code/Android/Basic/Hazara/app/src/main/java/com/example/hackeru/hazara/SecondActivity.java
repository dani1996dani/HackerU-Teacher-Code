package com.example.hackeru.hazara;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends Activity {

    private final int KILL_ME_RQ = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //get extra from intent, check if we need to jum to third activity
        boolean jumpToThird = getIntent().getBooleanExtra(MainActivity.JUMP_TO_THIRD, false);
        if(jumpToThird){
            goToThird(null);
        }
    }

    public void back(View view) {
        finish();
    }

    public void goToThird(View view) {
        Intent i = new Intent(this, ThirdActivity.class);
        startActivityForResult(i, KILL_ME_RQ);
    }

    @Override
    protected void onActivityResult(int request, int result, Intent data) {
        if(request == KILL_ME_RQ && result == RESULT_OK) {
            finish();
        }
    }
}
