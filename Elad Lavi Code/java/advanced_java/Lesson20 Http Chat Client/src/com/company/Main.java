package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        String userName = null, password = null, loginOrSignup = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("type 'login' or 'signup': ");
            loginOrSignup = scanner.next();
            if(!loginOrSignup.equals("login") && !loginOrSignup.equals("signup"))
                continue;
            System.out.println("please enter username: ");
            userName = scanner.next();
            if(userName.length() == 0)
                continue;
            System.out.println("please enter password: ");
            password = scanner.next();
            if(password.length() == 0)
                continue;
            if(ChatAPI.signup(userName,password,loginOrSignup.equals("login")))
                break;
        }

        PullMessagesThread pullMessagesThread = new PullMessagesThread(new PullMessagesThread.NewMessageHandler() {
            @Override
            public void handleNewMessage(Message message) {
                System.out.println(message);
            }
        }, userName, password);
        pullMessagesThread.start();
        System.out.println("type your message:");
        while (true){
            String message = scanner.nextLine();
            if(message.length() == 0)
                continue;
            if(message.equals("exit"))
                break;
            if(!ChatAPI.send(message, userName, password))
                System.out.println("error sending");
        }


    }



}
