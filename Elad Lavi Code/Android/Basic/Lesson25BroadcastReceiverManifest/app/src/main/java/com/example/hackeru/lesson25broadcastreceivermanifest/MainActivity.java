package com.example.hackeru.lesson25broadcastreceivermanifest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    private static final String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent("MY_SPECIFIC_ACTION");
        intent.putExtra(KEY, "my cool value2");
        sendBroadcast(intent);
    }
}
