package com.example.hackeru.lesson25_broadcastreceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class MainActivity extends Activity {

    public static final String KEY = "key";
    public static final String MY_SPECIFIC_ACTION = "MY_SPECIFIC_ACTION";
    private IntentFilter intentFilter;
    private MyBroadcastReceiver receiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        receiver = new MyBroadcastReceiver();
        intentFilter = new IntentFilter(MY_SPECIFIC_ACTION);

        //priority is between 0 to 1000. default is 0
        intentFilter.setPriority(10);
    }

    public void btnSendBroadcast(View view) {
        Intent intent = new Intent(MY_SPECIFIC_ACTION);
        intent.putExtra(KEY, "my cool value2");
        //sendBroadcast(intent);
        sendOrderedBroadcast(intent, null);

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    public class MyBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "received broadcast: " +
                    intent.getStringExtra(KEY), Toast.LENGTH_LONG).show();
            abortBroadcast();
        }
    }
}
