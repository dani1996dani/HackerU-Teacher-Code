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
import java.util.List;

public class ChatAPI {

    public static final String BASE_URL = "http://35.204.219.208/chat/ChatServlet";
    public static final String SIGNUP = "signup";
    public static final String LOGIN = "login";
    public static final String PULL = "pull";
    public static final String SEND = "send";
    public static final String OK = "OK";
    public static final String ERROR = "ERROR";
    public static final String SENDER = "sender";
    public static final String CONTENT = "content";

    public static String httpGet(String queryString){
        URL url = null;
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        try{
            url = new URL(BASE_URL + queryString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setUseCaches(false);
            connection.setRequestMethod("GET");
            byte[] buffer = new byte[1024];
            inputStream = connection.getInputStream();
            int actuallyRead = inputStream.read(buffer);
            String response = new String(buffer,0,actuallyRead);
            return response;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            closeConnection(inputStream,connection);
        }
        return null;
    }

    public static boolean signup(String userName, String password, boolean isLogin){
        String response = httpGet("?action="+(isLogin ? LOGIN : SIGNUP)+"&username="+userName+"&password="+password);
        return response.equals(OK);
    }

    public static boolean send(String message, String userName, String password){
        String response = httpGet("?action="+SEND+"&username="+userName+"&password="+password+"&"+CONTENT+"="+message);
        return  response.equals(OK);
    }

    public static boolean pull(String userName, String password, int from, PullMessagesThread.NewMessageHandler newMessageHandler){
        String response = httpGet("?action="+PULL+"&username="+userName+"&password="+password+"&from="+from);
        if(response.length() == 0)
            return false;
        try {
            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonMessage = jsonArray.getJSONObject(i);
                Message message = new Message(jsonMessage.getString(SENDER), jsonMessage.getString(CONTENT));
                newMessageHandler.handleNewMessage(message);
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void closeConnection(InputStream inputStream, OutputStream outputStream, HttpURLConnection connection){
        if(inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            connection.disconnect();
        }
    }

    public static void closeConnection(InputStream inputStream, HttpURLConnection connection){
        closeConnection(inputStream,null,connection);
    }
}
