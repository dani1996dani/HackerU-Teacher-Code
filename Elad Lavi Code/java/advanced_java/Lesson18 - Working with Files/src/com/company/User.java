package com.company;

import java.io.InputStream;
import java.io.OutputStream;

public class User {
    private String userName, password;
    private int id;


    public User(String userName, String password, int id) {
        this.userName = userName;
        this.password = password;
        this.id = id;
    }

    public User(InputStream inputStream){

    }

    public void out(OutputStream outputStream){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
