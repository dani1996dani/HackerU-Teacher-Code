package com.example.hackeru.hazara;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }


    public void backToMain(View view) {
        setResult(RESULT_OK);
        finish();
    }

    public void back(View view) {
        //setResult(RESULT_CANCELED);
        finish();
    }
}
