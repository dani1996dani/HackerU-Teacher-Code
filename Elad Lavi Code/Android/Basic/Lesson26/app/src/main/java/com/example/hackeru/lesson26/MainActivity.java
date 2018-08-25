package com.example.hackeru.lesson26;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private CheckBox chkOption1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        RadioGroup radioGroup1 = findViewById(R.id.radioGroup1);

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                String option = "";
                int opt = -1;
                String optionString = null;
                switch (id){
                    case R.id.option1:
                        option = "option 1";
                        opt = 0;
                        break;
                    case R.id.option2:
                        option = "option 2";
                        opt = 1;
                        break;
                    case R.id.option3:
                        option = "option 3";
                        opt = 2;
                        break;

                }
                RadioButton selectedRadioButton = findViewById(id);


                RadioButton selectedRadioButton = null;
                for (int i = 0; i < radioGroup.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton)radioGroup.getChildAt(i);
                    if(radioButton.isChecked()){
                        selectedRadioButton = radioButton;
                        break;
                    }
                }
                optionString = selectedRadioButton.getText().toString();

                Toast.makeText(MainActivity.this, "checked change: " + option, Toast.LENGTH_SHORT).show();
            }
        });

        radioGroup1.check(R.id.option1);
        */
        chkOption1 = findViewById(R.id.chkOption1);
        //chkOption1.setTag(new Float(34.4f));
        chkOption1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                Toast.makeText(MainActivity.this, "option 1: "
                        + (checked ? "checked" : "unchecked"), Toast.LENGTH_SHORT).show();
                String tag = (String) chkOption1.getTag();
            }
        });
    }

    private void submit(){
        boolean isOption1Check = chkOption1.isChecked();
    }

    public void btnOnClick(View view) {
        Toast.makeText(this, "clicked!", Toast.LENGTH_SHORT).show();
    }
}
