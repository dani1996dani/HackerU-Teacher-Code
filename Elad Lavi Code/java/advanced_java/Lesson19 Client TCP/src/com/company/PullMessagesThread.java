package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import static com.company.Main.*;


public class PullMessagesThread extends Thread {

    private int from = 0;
    private boolean go = true;
    private String userName, password;

    public PullMessagesThread(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void run() {
        while (go) {
            pull();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void pull(){
        Socket clientSocket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            clientSocket = new Socket(HOST, PORT);
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();
            outputStream.write(PULL);

            //send the userName:
            byte[] userNameBytes = userName.getBytes();
            outputStream.write(userNameBytes.length);
            outputStream.write(userNameBytes);

            //send the password:
            byte[] passwordBytes = password.getBytes();
            outputStream.write(passwordBytes.length);
            outputStream.write(passwordBytes);

            //send from which message the client wishes to pull message from:
            byte[] fromBytes = new byte[4];
            ByteBuffer.wrap(fromBytes).putInt(from);
            outputStream.write(fromBytes);
            Message message = null;
            while ((message = Message.createFromStream(inputStream)) != null){
                System.out.println(message);
                from++;
            }

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
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stopPulling(){
        go = false;
        interrupt();
    }
}
