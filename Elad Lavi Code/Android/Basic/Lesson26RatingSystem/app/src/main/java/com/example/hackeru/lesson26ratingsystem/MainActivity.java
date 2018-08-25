package com.example.hackeru.lesson26ratingsystem;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private ViewGroup mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        String[] questions = {"question 1", "question 2", "question 3"};

        /*
        TextView textView = new TextView(this);
        textView.setText("test");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mainLayout.addView(textView, layoutParams);
        */

        MyRatingView myRatingView = new MyRatingView(this, "my question");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mainLayout.addView(myRatingView, layoutParams);
        myRatingView.setValue(3);
        Log.d("elad", "test");

        /*

        for (int i = 1; i <= 5; i++) {
            CheckBox star = rating1.findViewWithTag(String.valueOf(i));
            star.setOnClickListener(listener);
        }
        */


    }

    /*
    public void startClicked(View view){
        String tag = (String)view.getTag();
        int starNum = Integer.valueOf(tag);

        for (int i = 1; i <= 5; i++) {
            CheckBox chkStar = rating1.findViewWithTag(String.valueOf(i));
            chkStar.setChecked(i <= starNum);
        }

    }
*/
    /*
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
    */
}
