package com.company;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        httpPostExample();
    }

    private static void httpPostExample() {
        URL url = null;
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try{
            url = new URL("http://localhost:8080/MainServlet?username=elad&password=12345");

            connection = (HttpURLConnection) url.openConnection();
            connection.setUseCaches(false);
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            outputStream = connection.getOutputStream();
            outputStream.write("bla bla bla".getBytes());

            //connection.setConnectTimeout(100);
            //connection.setReadTimeout(100);
            inputStream = connection.getInputStream();
            byte[] buffer = new byte[1024];
            int actuallyRead = inputStream.read(buffer);
            System.out.println(new String(buffer,0,actuallyRead));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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

    private static void httpGetExample() {
        URL url = null;
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        try{
            url = new URL("http://localhost:8080/MainServlet?username=elad&password=12345");
            connection = (HttpURLConnection) url.openConnection();
            connection.setUseCaches(false);
            connection.setRequestMethod("GET");
            //connection.setConnectTimeout(100);
            //connection.setReadTimeout(100);
            inputStream = connection.getInputStream();
            byte[] buffer = new byte[1024];
            int actuallyRead = inputStream.read(buffer);
            System.out.println(new String(buffer,0,actuallyRead));

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
}
