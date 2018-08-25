package com.example;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends javax.servlet.http.HttpServlet {

    //  URL:
    //  protocol://host:port/path?querystring
    //  http://www.google.com?q=dog

    private int counter;

    @Override
    public void init() throws ServletException {
        super.init();
        counter = 0;
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        InputStream inputStream = request.getInputStream();
        byte[] buffer = new byte[1024];
        int actuallyRead = inputStream.read(buffer);
        String messageFromClient = new String(buffer,0,actuallyRead);

        OutputStream outputStream = response.getOutputStream();
        outputStream.write("Ninjava".getBytes());
        System.out.println("in doPost() " + messageFromClient);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("in doGet() " +counter);
        /*
        if(request.getQueryString() == null)
            return;
        String[] keyValuePairs = request.getQueryString().split("&");
        Map<String,String> qs = new HashMap<>();
        for(String keyValuePair : keyValuePairs){
            String[] keyValue = keyValuePair.split("=");
            if(keyValue.length != 2)
                return;
            qs.put(keyValue[0],keyValue[1]);
        }
        String userName = qs.get("username");
        String password = qs.get("password");
        if(userName == null || password == null)
            return;

        */
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(userName + " " + password);
        //response.getWriter().write("<!DOCTYPE html><html><head></head><body><h1>counter = " + counter+"</h1></body></html>");
        //response.getWriter().write("counter="+counter);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(String.valueOf(i));

        }
        response.getWriter().write(stringBuilder.toString());
        counter++;
    }


    @Override
    public void destroy() {
        super.destroy();
    }
}
