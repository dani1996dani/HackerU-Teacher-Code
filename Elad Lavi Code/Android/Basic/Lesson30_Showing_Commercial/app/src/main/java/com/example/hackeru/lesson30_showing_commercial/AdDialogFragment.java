package com.example.hackeru.lesson30_showing_commercial;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class AdDialogFragment extends DialogFragment implements TimerThread.TimerListener {


    private TimerThread timerThread;
    private Handler handler = new Handler();
    private AdDismissedListener adDismissedListener;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ad, container, false);
        ImageView banner = view.findViewById(R.id.banner);
        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),
                        "Shadows are Ninja's most powerful weapon", Toast.LENGTH_SHORT).show();
            }
        });

        if(timerThread == null) {
            timerThread = new TimerThread(4, this, false);
            timerThread.start();
        }
        return view;
    }


    @Override
    public void onTimer() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        });
        if(adDismissedListener != null)
            adDismissedListener.adDismissed();
    }

    @Override
    public void onTick(int counter) {

    }

    public interface AdDismissedListener {
        void adDismissed();
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        if(adDismissedListener != null)
            adDismissedListener.adDismissed();
    }

    public void setAdDismissedListener(AdDismissedListener adDismissedListener) {
        this.adDismissedListener = adDismissedListener;
    }
}
