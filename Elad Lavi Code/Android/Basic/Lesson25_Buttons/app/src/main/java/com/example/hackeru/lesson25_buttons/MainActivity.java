package com.example.hackeru.lesson25_buttons;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        "Button 3 was clicked", Toast.LENGTH_SHORT).show();
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(listener);

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(listener);

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button)view;
            Toast.makeText(MainActivity.this, button.getText() + " was clicked", Toast.LENGTH_SHORT).show();
        }
    };

    public void onClick(View view) {
        Button button = (Button)view;
        Toast.makeText(MainActivity.this, button.getText() + " was clicked", Toast.LENGTH_SHORT).show();
    }

    public void onToggle(View view) {
        ToggleButton toggleButton = (ToggleButton)view;
        Toast.makeText(this, "toggle mode: " + toggleButton.isChecked(), Toast.LENGTH_SHORT).show();
    }
}
