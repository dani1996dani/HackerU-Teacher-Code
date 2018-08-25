package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] options = {"add", "subtract", "multiply", "divide"};
        int selectedOption = printMenu(options);

    }

    public static int printMenu(String[] options){

        for (int i = 0; i < options.length; i++) {
            System.out.println((i+1) + ". " + options[i]);
        }
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        int optionAsInt = -1;
        try{
            optionAsInt = Integer.valueOf(option);
        }catch (Exception ex){
            System.out.println("invalid input.");
            return printMenu(options);
        }
        if(optionAsInt < 1 || optionAsInt > options.length){
            System.out.println("must be between 1 to " + options.length);
            return printMenu(options);
        }
        return optionAsInt;
    }

    public static int binaryToBaseTen(int[] arr){
        int sum = 0;
        int k = 1;
        for (int i = arr.length-1; i >= 0; i--) {
            sum += arr[i] * k;
            k *= 2;
        }
        return sum;
    }




}
