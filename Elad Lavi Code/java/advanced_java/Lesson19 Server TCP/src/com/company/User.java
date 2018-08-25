package com.company;

import java.io.IOException;
import java.io.InputStream;

public class User {
    private String userName, password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(InputStream inputStream) throws IOException {
        int userNameLength = inputStream.read();
        if(userNameLength == -1)
            return;
        byte[] userNameBytes = new byte[userNameLength];
        int actuallyRead = inputStream.read(userNameBytes);
        if(actuallyRead != userNameLength)
            return;
        int passwordLength = inputStream.read();
        if(passwordLength == -1)
            return;
        byte[] passwordBytes = new byte[passwordLength];
        actuallyRead = inputStream.read(passwordBytes);
        if(actuallyRead != passwordLength)
            return;
        this.userName = new String(userNameBytes);
        this.password = new String(passwordBytes);
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
