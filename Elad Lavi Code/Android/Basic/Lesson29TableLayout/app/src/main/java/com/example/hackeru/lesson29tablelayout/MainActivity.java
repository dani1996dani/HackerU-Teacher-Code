package com.example.hackeru.lesson29tablelayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements LoginThread.LoginListener {

    private EditText txtUserName, txtPassword;
    private Button btnLogin, btnSignup;
    private TextView lblMessage;
    private Handler handler = new Handler();
    private boolean success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUserName = findViewById(R.id.txtUserName);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);
        lblMessage = findViewById(R.id.lblMessage);
    }

    private void lockUI(boolean unlock){
        btnSignup.setEnabled(unlock);
        btnLogin.setEnabled(unlock);
        txtUserName.setEnabled(unlock);
        txtPassword.setEnabled(unlock);
        lblMessage.setText(unlock ? R.string.enter_your_credentials : R.string.please_wait);
    }

    public void btnLogin(View view) {
        loginOrSignup(true);
    }

    private void loginOrSignup(boolean isLogin){
        String userName = txtUserName.getText().toString();
        String password = txtPassword.getText().toString();
        if(userName.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "must enter both username and password!", Toast.LENGTH_SHORT).show();
            return;
        }
        lockUI(false);
        new LoginThread(userName, password, this, isLogin).start();
    }

    public void btnSignup(View view) {
        loginOrSignup(false);
    }

    @Override
    public void onLogin(boolean success) {
        this.success = success;
        handler.post(new Runnable() {
            @Override
            public void run() {
                lockUI(true);
                if(MainActivity.this.success){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
