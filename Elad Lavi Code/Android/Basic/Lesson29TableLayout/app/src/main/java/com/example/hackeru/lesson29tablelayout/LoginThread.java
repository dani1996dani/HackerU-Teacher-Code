package com.example.hackeru.lesson29tablelayout;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginThread extends Thread {

    public static final String OK = "OK";
    private String userName, password;
    private LoginListener listener;
    private boolean isLogin;


    public LoginThread(String userName, String password, LoginListener listener, boolean isLogin){
        this.userName = userName;
        this.password = password;
        this.listener = listener;
        this.isLogin = isLogin;
    }

    @Override
    public void run() {
        if(listener == null)
            return;
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        try {
            String action = isLogin ? "login" : "signup";
            URL url = new URL("http://10.0.2.2:8080/MainServlet?action="+action
                    +"&username="+userName+"&password="+password);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            inputStream = connection.getInputStream();
            byte[] buffer = new byte[64];
            int actuallyRead = inputStream.read(buffer);
            if(actuallyRead == -1)
                listener.onLogin(false);
            else {
                String responseFromServer = new String(buffer, 0, actuallyRead);
                listener.onLogin(responseFromServer.equals(OK));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null)
                connection.disconnect();
        }
    }


    public interface LoginListener{
        void onLogin(boolean success);
    }
}
