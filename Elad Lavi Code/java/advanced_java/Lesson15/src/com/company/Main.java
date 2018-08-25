package com.company;

import javafx.application.Application;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class Main {

    static int max, min, sum;
    static boolean atLeastOneNumber;
    static {
        sum = 0;
        atLeastOneNumber = false;
    }

    public static void main(String[] args) {

        MenuOption.OptionSelectedListener listener = new MenuOption.OptionSelectedListener() {
            @Override
            public void optionSelected(int val) {
                try {
                    int x = MenuOption.getIntFromUser("enter first number");
                    int y = MenuOption.getIntFromUser("enter second number");
                    int result = 0;
                    switch (val){
                        case 1:
                            result = x + y;
                            break;
                        case 2:
                            result = x - y;
                            break;
                        case 3:
                            result = x * y;
                            break;
                        case 4:
                            if(y == 0){
                                System.out.println("division by zero is not allowed!");
                                return;
                            }
                            result = x / y;
                            break;

                    }
                    System.out.println("the result is: " + result);
                } catch (MenuOption.CancelException e) {

                }
            }
        };
        MenuOption[] menuOptions = {
                new MenuOption("add", listener, 1),
                new MenuOption("subtract", listener, 2),
                new MenuOption("multiply", listener, 3),
                new MenuOption("divide", listener, 4),
                new MenuOption("exit", new MenuOption.OptionSelectedListener() {
                    @Override
                    public void optionSelected(int val) {
                        System.out.println("traot");
                        System.exit(0);
                    }
                })
        };
        MenuOption.menuOptions = menuOptions;
        MenuOption.menu();
    }

    private static void targil1() {
        MenuOption[] mainMenu = {
                new MenuOption("enter a number", new MenuOption.OptionSelectedListener() {
                    @Override
                    public void optionSelected(int val) {
                        try {
                            getNumberFromUser();
                        } catch (MenuOption.CancelException e) {

                        }
                    }
                }),
                new MenuOption("sum of numbers", new MenuOption.OptionSelectedListener() {
                    @Override
                    public void optionSelected(int val) {
                        System.out.println("the sum is: " + sum);
                    }
                }),
                new MenuOption("min number", new MenuOption.OptionSelectedListener() {
                    @Override
                    public void optionSelected(int val) {
                        if(!atLeastOneNumber)
                            System.out.println("no numbers were enter yet.");
                        else
                            System.out.println("the min is: " + min);

                    }
                }),
                new MenuOption("max number", new MenuOption.OptionSelectedListener() {
                    @Override
                    public void optionSelected(int val) {
                        if(!atLeastOneNumber)
                            System.out.println("no numbers were enter yet.");
                        else
                            System.out.println("the max is: " + max);
                    }
                }),
                new MenuOption("enter series of numbers:", new MenuOption.OptionSelectedListener() {
                    @Override
                    public void optionSelected(int val) {
                        try{
                            int howManyNumbers = MenuOption.getIntFromUser("how many numbers would you like to insert?  ", 1, Integer.MAX_VALUE);
                            for (int i = 0; i < howManyNumbers; i++) {
                                getNumberFromUser();
                            }
                        }catch (MenuOption.CancelException ex){

                        }

                    }
                }),

                new MenuOption("exit", new MenuOption.OptionSelectedListener() {
                    @Override
                    public void optionSelected(int val) {
                        System.out.println("bye bye! c ya later alligator!");
                        MenuOption.shouldRecurse = false;
                        System.exit(0);
                    }
                }),

        };
        MenuOption.menuOptions = mainMenu;
        MenuOption.menu();
    }

    private static void getNumberFromUser() throws MenuOption.CancelException {
        int num = MenuOption.getIntFromUser("please enter a number");
        sum += num;
        if(atLeastOneNumber) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }else{
            min = num;
            max = num;
            atLeastOneNumber = true;
        }
    }


    private static void example1() {
        MotionSensor motionSensor = new MotionSensor();
        /*MotionSensor.MotionSensorListener listener = new MotionSensor.MotionSensorListener() {
            @Override
            public void motionDetected(int motionIntensity) {
                System.out.println("calling the police");
            }
        };*/
        Police police = new Police();


        //motionSensor.setListener(listener);
        motionSensor.setListener(police);
        motionSensor.detectMotion();
    }
}

class MotionSensor{

    private MotionSensorListener listener;

    public void detectMotion(){

        //code that runs forever
        //motion detected
        if(listener != null)
            listener.motionDetected(123);
    }

    public void setListener(MotionSensorListener listener){
        this.listener = listener;
    }

    interface MotionSensorListener{
        void motionDetected(int motionIntensity);
    }

}
