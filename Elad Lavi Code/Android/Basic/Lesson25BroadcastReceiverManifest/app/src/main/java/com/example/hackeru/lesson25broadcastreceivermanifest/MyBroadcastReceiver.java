package com.example.hackeru.lesson25broadcastreceivermanifest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    public static final String KEY = "key";

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "onReceive " + intent.getStringExtra(KEY),
                Toast.LENGTH_LONG).show();
        Log.d("Elad", "onReceive " + intent.getStringExtra(KEY));
    }
}
