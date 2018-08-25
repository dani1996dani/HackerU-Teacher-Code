package com.example.hackeru.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends Activity {

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);



    }

    public void btnClose(View view) {
        Intent data = new Intent();
        data.putExtra(USERNAME, "dfsgdg");
        data.putExtra(PASSWORD, 345345);

        setResult(RESULT_OK, data);
        finish();
    }
}
