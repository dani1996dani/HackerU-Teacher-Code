package com.example.hackeru.lesson25callingbuiltinapps;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent intent = new Intent(Intent.ACTION_VIEW);
        //intent.setData(Uri.parse("geo:31.084769, 34.800883"));


        //Intent intent = new Intent(Intent.ACTION_VIEW);
        //intent.setData(Uri.parse("market://details?id=com.waze"));

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String[] to = {"35345@fdgg.com", "gfdgdfgh@sdfs.com"};
        String[] cc = {"dtgdfghfh@sgg.com", "fsdgfdfhg@dfgdg.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_CC, cc);
        intent.putExtra(Intent.EXTRA_SUBJECT, "the subject");
        intent.putExtra(Intent.EXTRA_TEXT, "the content");
        intent.setType("message/rfc822");
        startActivity(intent);


        startActivity(intent);
    }
}
