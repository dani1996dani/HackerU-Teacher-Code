package com.company;

public class Main {

    public static void main(String[] args) {
        Rollable rollable = () -> System.out.println("I'm rolling");
        rollable.roll();

        Button loginButton = new Button();
        loginButton.setText("login");
        loginButton.setListener(new Button.OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("I am clicked");
            }
        });
        loginButton.runForEver();
    }
}
class Button{

    private OnClickListener listener;
    private String text;

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void runForEver(){


        if(listener != null)
            listener.onClick();
    }

    public interface OnClickListener{
        void onClick();
    }
}