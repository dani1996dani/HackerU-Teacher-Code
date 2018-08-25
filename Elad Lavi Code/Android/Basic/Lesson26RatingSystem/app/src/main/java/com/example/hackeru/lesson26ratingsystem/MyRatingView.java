package com.example.hackeru.lesson26ratingsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.security.InvalidParameterException;

public class MyRatingView extends FrameLayout {

    private int starNum;
    private TextView lblQuestion;

    public MyRatingView(Context context, String question) {
        super(context);

        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.rating, this, false);
        addView(view);
        for (int i = 1; i <= 5; i++) {
            View chkStar = view.findViewWithTag(String.valueOf(i));
            chkStar.setOnClickListener(listener);
        }
        lblQuestion = view.findViewById(R.id.lblQuestion);
        setQuestion(question);

    }

    public void setQuestion(String question){
        if(question != null)
            lblQuestion.setText(question);
    }

    public String getQuestion(){
        return lblQuestion.getText().toString();
    }


    public int getValue() {
        return starNum;
    }
    public void setValue(int value){
        if(value < 1 || value > 5)
            throw new InvalidParameterException();
        this.starNum = value;
        setChecked();
    }

    private OnClickListener listener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            starNum = Integer.valueOf((String)view.getTag());
            setChecked();
        }
    };

    private void setChecked() {
        for (int i = 1; i <= 5; i++) {
            CheckBox chkStar = findViewWithTag(String.valueOf(i));
            chkStar.setChecked(i<=starNum);
        }
    }
}
