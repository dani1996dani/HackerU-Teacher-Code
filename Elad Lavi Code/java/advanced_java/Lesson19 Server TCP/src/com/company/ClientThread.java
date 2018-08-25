package com.company;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public class ClientThread extends Thread {

    public static final int SEND = 50;
    public static final int PULL = 51;
    public static final int OKAY = 200;
    public static final int ERROR = 201;
    public static final int SIGNUP = 52;
    public static final int LOGIN = 53;
    private Socket clientSocket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private List<Message> messages;
    private Map<String, String> users;

    public ClientThread(Socket clientSocket, List<Message> messages, Map<String, String> users) {
        this.clientSocket = clientSocket;
        this.messages = messages;
        this.users = users;
    }

    @Override
    public void run() {
        try {
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();
            int action = inputStream.read();
            switch (action){
                case SEND:
                    send();
                    break;
                case PULL:
                    pull();
                    break;
                case SIGNUP:
                    signup();
                    break;
                case LOGIN:
                    login();
                    break;
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
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(clientSocket != null){
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void send() throws IOException{
        User user = new User(inputStream);
        if(!validUser(user))
            return;
        int messageLength = inputStream.read();
        if(messageLength == -1)
            return;
        byte[] messageBytes = new byte[messageLength];
        int actuallyRead = inputStream.read(messageBytes);
        if(actuallyRead != messageLength)
            return;
        messages.add(new Message(new String(messageBytes),user.getUserName()));
        outputStream.write(OKAY);
    }

    private void pull() throws IOException{
        User user = new User(inputStream);
        if(!validUser(user))
            return;
        byte[] fromBytes = new byte[Integer.BYTES];
        int actuallyRead = inputStream.read(fromBytes);
        if(actuallyRead != Integer.BYTES)
            return;
        int from = ByteBuffer.wrap(fromBytes).getInt();
        for (int i = from; i < messages.size(); i++) {
            messages.get(i).write(outputStream);
        }
    }

    private void signup() throws IOException{
        User user = new User(inputStream);
        boolean success = false;
        synchronized (users) {
            if (!users.containsKey(user.getUserName())) {
                users.put(user.getUserName(), user.getPassword());
                success = true;
            }
        }
        outputStream.write(success ? OKAY : ERROR);
    }

    private boolean validUser(User clientUser){
        String existingPassword = users.get(clientUser.getUserName());
        return existingPassword != null && existingPassword.equals(clientUser.getPassword());

    }


    private void login() throws IOException {
        User clientUser = new User(inputStream);
        outputStream.write(validUser(clientUser) ? OKAY : ERROR);

    }
}
