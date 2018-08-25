package com.company;

import java.util.ArrayList;
import java.util.List;

public class PullMessagesThread extends Thread {

    private boolean go = true;
    private List<Message> messages;
    private NewMessageHandler newMessageHandler;

    private String userName, password;


    public PullMessagesThread(NewMessageHandler newMessageHandler, String userName, String password) {
        this.newMessageHandler = newMessageHandler;
        this.userName = userName;
        this.password = password;
        messages = new ArrayList<>();

    }

    @Override
    public void run() {
        while (go){

            ChatAPI.pull(userName, password, messages.size(), new NewMessageHandler() {
                @Override
                public void handleNewMessage(Message message) {
                    messages.add(message);
                    newMessageHandler.handleNewMessage(message);
                }
            });

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopPullingMessages(){
        go = false;
        interrupt();
    }

    public interface NewMessageHandler{
        void handleNewMessage(Message message);
    }
}
