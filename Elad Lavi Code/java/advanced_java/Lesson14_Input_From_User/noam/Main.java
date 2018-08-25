package com.company;


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        boolean go = true;
        int x, y;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("please choose your action");
            System.out.println("1.+");
            System.out.println("2.-");
            System.out.println("3.*");
            System.out.println("4./");
            System.out.println("5.Exit");
            String action = scanner.next();
            Operator operator = Operator.INVALID;
            switch (action) {
                case "1":
                    operator = Operator.ADD;

                    break;
                case "2":
                    operator = Operator.SUBTRACT;
                    break;
                case "3":
                    operator = Operator.MULTIPLY;
                    break;
                case "4":
                    operator = Operator.DIVIDE;
                    break;
                case "5":
                    System.out.println("Bye Bye");
                    go = false;
                    break;
                default:
                    System.out.println("the input is incorrect, please choose a correct action from the list");


            }
            if(!go)
                break;
            if(operator == Operator.INVALID)
                continue;
            System.out.println("please enter first number");
            x = Integer.valueOf(scanner.next());
            System.out.println("please enter second number");
            y = Integer.valueOf(scanner.next());
            int result = 0;
            switch (operator){
                case ADD:
                    result = x + y;
                    break;
                case DIVIDE:
                    if(y == 0){
                        System.out.println("error");
                        continue;
                    }
                    result = x / y;
                    break;
                case MULTIPLY:
                    result = x * y;
                    break;
                case SUBTRACT:
                    result = x - y;
                    break;
            }
            System.out.println("the result is " + result);
        }while(go);
        scanner.close();


    }

    public static String getNumber1(Scanner scanner) {
        System.out.println("please enter the first number");
        return scanner.next();
    }

    public static String getNumber2(Scanner scanner){
        System.out.println("please enter the second number");
        return scanner.next();
    }

}

