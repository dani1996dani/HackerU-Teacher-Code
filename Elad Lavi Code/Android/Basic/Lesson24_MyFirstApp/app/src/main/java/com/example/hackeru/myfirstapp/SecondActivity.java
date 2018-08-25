package com.example.hackeru.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static com.example.hackeru.myfirstapp.MainActivity.*;
public class SecondActivity extends Activity {

    public static final int REQUEST_CODE = 52;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        //Intent intent =  new Intent(this, ThirdActivity.class);
        //startActivity(intent);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int age = extras.getInt(AGE, -1);
        String name = extras.getString(NAME);
        //int age = intent.getIntExtra(AGE, -1);
        //String name = intent.getStringExtra(NAME);

        Toast.makeText(this, "name="+name + ", age="+age, Toast.LENGTH_SHORT).show();




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String userName = data.getStringExtra(ThirdActivity.USERNAME);
                int password = data.getIntExtra(ThirdActivity.PASSWORD, 0);
                Toast.makeText(this, "userName="+userName+
                        " ,password="+password, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void btnGoToThird(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }
}
