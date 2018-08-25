package com.example.hackeru.lesson29dialogfragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginFragment extends DialogFragment {

    private EditText txtUserName, txtPassword;
    private Button btnDone, btnCancel;
    private TextView lblTitle;
    private String title;
    private LoginFragmentListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        txtUserName = view.findViewById(R.id.txtUserName);
        txtPassword = view.findViewById(R.id.txtPassword);
        btnDone = view.findViewById(R.id.btnDone);
        btnCancel = view.findViewById(R.id.btnCancel);
        lblTitle = view.findViewById(R.id.lblTitle);
        lblTitle.setText(title);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = txtUserName.getText().toString();
                String password = txtPassword.getText().toString();
                if(userName.length() < 3 || password.length() < 3){
                    Toast.makeText(view.getContext(), "must...", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(listener != null)
                    listener.done(userName,password);
                dismiss();
            }
        });
        return view;
    }


    public void setListener(LoginFragmentListener listener) {
        this.listener = listener;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public interface LoginFragmentListener{
        void done(String userName, String password);
    }
}
