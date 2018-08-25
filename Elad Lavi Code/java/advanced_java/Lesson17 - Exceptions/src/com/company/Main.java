package com.company;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        System.out.println("hello world");
        int[] arr = {123,345};
        try {
            System.out.println("beginning of try block");
            int x = arr[10];

            int a = 7;
            int b = 0;
            if(b == 0)
                throw new DivisionByZeroException();
            int c = a / b;
            System.out.printf("the value of x is %d", x);
            System.out.println();
            //return c;
        }catch (DivisionByZeroException ex){
            //write to database
            throw ex;
        }catch (ArrayIndexOutOfBoundsException ex){

        }catch (NullPointerException ex){

        } catch (Exception ex){
            /*
            if(ex instanceof ArrayIndexOutOfBoundsException){

            }else if(ex instanceof NullPointerException){

            }else{

            }
            */
            System.out.println("big balagan. something bad happened. ");
            System.out.println(" what happened ? " + ex);
            ex.printStackTrace();
        }finally {
            System.out.println("is guaranteed to be executed after all try and catch");
        }

        System.out.println("done");
        try {
            double divisionResult = divide(5, 8);
        }catch (DivisionByZeroException e){

        }
        try {
            exampleThrowingException();
        }catch (MyException e){

        }
        /*
        DatabaseConnection databaseConnection = null;
        try{
            databaseConnection = new DatabaseConnection();
            //return;
        }catch (Exception ex){

        }finally {
            if (databaseConnection != null)
                try {
                    databaseConnection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        */
        try(DatabaseConnection databaseConnection = new DatabaseConnection()){
            return;
        }catch (Exception ex){

        }

    }

    static boolean validateLogin(String userName, String password){
        boolean isValid = false;
        try{
            //go to the server to validate the user
            return true;
        }catch (Exception ex){

        }finally {
            //clean up code that terminates connection to the server properly

        }

        return isValid;
    }

    static double divide(int x, int y){
        if (y == 0)
            throw new DivisionByZeroException();
        else return (double) x / y;
    }

    public static void exampleThrowingException() throws MyException, DivisionByZeroException{
        throw new MyException();
    }

    public static void example2() throws MyException{
        /*
        try {
            exampleThrowingException();
        }catch (MyException e){

        }
        */
        exampleThrowingException();
    }

    static class MyException extends Exception{
        long when;

        public MyException() {
            when = System.currentTimeMillis();
        }
    }

    static class DivisionByZeroException extends RuntimeException{

    }
}

class DatabaseConnection implements Closeable {


    public DatabaseConnection() throws Exception {
    }

    @Override
    public void close() throws IOException {
        System.out.println("clean up. bye bye connection");
    }
}