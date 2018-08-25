package com.example.hackeru.lesson28framelayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int count = 0;
    private FrameLayout frameLayout;
    private ImageView imageView;
    private TextView title;
    private String[] names = {"Bibi", "Boozi", "Edelstein"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameLayout);
        title = findViewById(R.id.title);

    }



    public void btnNext(View view) {

        updateUI(true);
    }

    private void updateUI(boolean increment){
        imageView = frameLayout.findViewWithTag(String.valueOf(count));
        imageView.setVisibility(View.INVISIBLE);
        if(increment)
            count++;
        else
            count--;
        if(count == 3)
            count = 0;
        else if(count == -1)
            count = 2;
        imageView = frameLayout.findViewWithTag(String.valueOf(count));
        imageView.setVisibility(View.VISIBLE);
        title.setText(names[count]);
    }


    public void btnPrevious(View view) {
        updateUI(false);
    }
}
