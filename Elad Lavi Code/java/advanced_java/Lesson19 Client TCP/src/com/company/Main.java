package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static final String HOST = "127.0.0.1";
    public static final int PORT = 3000;

    public static final int SIGNUP = 52;
    public static final int LOGIN = 53;
    public static final int SEND = 50;
    public static final int PULL = 51;
    public static final int OKAY = 200;




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userName = null, password = null;
        while (true) {
            System.out.println("1. login");
            System.out.println("2. signup");

            String option = scanner.next();
            boolean loginOrSignup = false;
            switch (option) {
                case "1":
                    loginOrSignup = true;
                    break;
                case "2":
                    loginOrSignup = false;
                    break;
                default:
                    continue;
            }
            System.out.println("please enter user name:");
            userName = scanner.next();
            System.out.println("please enter password:");
            password = scanner.next();
            if (userName.length() == 0 || password.length() == 0)
                continue;
            if (login(userName, password, loginOrSignup))
                break;
        }

        System.out.println("welcome.");
        PullMessagesThread pullMessagesThread = new PullMessagesThread(userName, password);
        pullMessagesThread.start();


        while (true){
            String input = scanner.nextLine();
            if(input.equals("exit"))
                break;
            send(input, userName, password);
        }
        pullMessagesThread.stopPulling();


    }

    private static boolean login(String userName, String password, boolean isLogin){
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try{
            socket = new Socket(HOST, PORT);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            outputStream.write(isLogin ? LOGIN : SIGNUP);
            byte[] userNameBytes = userName.getBytes();
            outputStream.write(userNameBytes.length);
            outputStream.write(userNameBytes);
            byte[] passwordBytes = password.getBytes();
            outputStream.write(passwordBytes.length);
            outputStream.write(passwordBytes);
            int result = inputStream.read();
            return result == OKAY;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    private static void send(String message, String userName, String password) {
        Socket clientSocket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            clientSocket = new Socket(HOST, PORT);
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();
            outputStream.write(SEND);

            //send the userName:
            byte[] userNameBytes = userName.getBytes();
            outputStream.write(userNameBytes.length);
            outputStream.write(userNameBytes);

            //send the password:
            byte[] passwordBytes = password.getBytes();
            outputStream.write(passwordBytes.length);
            outputStream.write(passwordBytes);

            //send the message:
            byte[] messageBytes = message.getBytes();
            outputStream.write(messageBytes.length);
            outputStream.write(messageBytes);

            int response = inputStream.read();
            if (response != OKAY) {
                System.out.println("error sending");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

