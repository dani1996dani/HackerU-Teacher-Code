package com.example.hackeru.lesson30_showing_commercial;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TimerThread.TimerListener, AdDialogFragment.AdDismissedListener {


    private TimerThread inactivityThread;
    private Handler handler = new Handler();
    private TextView lblCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblCounter = findViewById(R.id.lblCounter);

    }

    private void updateCounterLabel(final int counter){
        lblCounter.setText(String.valueOf(counter));
    }

    @Override
    protected void onResume() {
        super.onResume();
        startTimer();
    }



    @Override
    protected void onPause() {
        super.onPause();
        stopTimer();

    }



    public void btnClickMe(View view) {
        inactivityThread.reset();
        updateCounterLabel(0);
    }

    @Override
    public void onTimer() {
        stopTimer();
        handler.post(new Runnable() {
            @Override
            public void run() {
                AdDialogFragment adDialogFragment = new AdDialogFragment();
                //adDialogFragment.setCancelable(false);
                adDialogFragment.setAdDismissedListener(MainActivity.this);
                adDialogFragment.show(getFragmentManager(), "");
            }
        });
    }

    @Override
    public void onTick(final int counter) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                updateCounterLabel(counter);
            }
        });
    }

    private void stopTimer(){
        if(inactivityThread != null){
            inactivityThread.stopTimer();
            inactivityThread = null;
        }

    }

    private void startTimer(){
        if(inactivityThread == null){
            inactivityThread = new TimerThread(10, this, false);
            inactivityThread.start();
        }
    }
    @Override
    public void adDismissed() {
        startTimer();
    }
}
