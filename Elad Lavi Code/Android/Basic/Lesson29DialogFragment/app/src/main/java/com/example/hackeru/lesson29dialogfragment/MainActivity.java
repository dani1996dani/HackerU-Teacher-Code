package com.example.hackeru.lesson29dialogfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity implements LoginFragment.LoginFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnShowFragment(View view) {
        LoginFragment loginFragment = new LoginFragment();
        loginFragment.setTitle("enter your credentials");
        loginFragment.setListener(this);
        loginFragment.setCancelable(false);
        loginFragment.show(getFragmentManager(), "");
    }

    @Override
    public void done(String userName, String password) {
        Toast.makeText(this, userName + " " + password, Toast.LENGTH_SHORT).show();
    }
}
