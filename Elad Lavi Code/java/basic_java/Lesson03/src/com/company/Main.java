package com.company;

public class Main {

    public static void main(String[] args) {
        drawRectangle(10,4,6,6);

    }

    static int distance(int x, int y){
        int small = x;
        int large = y;
        if(x > y){
            small = y;
            large = x;
        }
        int result = 0;
        while (small + result < large)
            result++;
        return result;
    }

    static int product(int x, int y){
        int small = x;
        int large = y;
        if(x > y){
            small = y;
            large = x;
        }
        int result = 0;
        for (int i = 0; i < small; i++)
            result += large;
        return result;
    }

    static int quotient(int x, int y){
        if(y == 0)
            return -1;
        int result = 0;
        int sum = y;
        while (sum <= x){
            sum += y;
            result++;
        }
        return result;
    }
    static int remainder(int x, int y){
        if(y == 0)
            return -1;
        return distance(x,product(quotient(x,y), y));
    }

    /*
    static int power(int x, int y) {
        if (y == 0){
            if(x==0)
                return -1;
            return 1;
        }
        if (x == 0 || x == 1)
            return x;



        int result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }
    */

    static int power(int x, int y) {
        if (y == 0) {
            if (x == 0)
                return -1;
            return 1;
        }
        if (x == 0 || x == 1)
            return x;

        return power(x,y-1) * x;


    }

    static int sqrt(int x){
        int result = 0;
        while (result * result < x)
            result++;
        return result;
    }


    static void drawRectangle(int left, int top, int width, int height){
        for (int i = 0; i < top; i++)
            System.out.println();

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < left; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < width; i++) {
                boolean isFrame = j==0 || j==height-1 || i==0 || i==width-1;

                System.out.print(isFrame ? "*" : " ");
            }
            System.out.println();
        }


    }


    //power(7,4)
    //(power(7,3)) * 7
    //(power(7,2) * 7) * 7
    //((power(7,1) * 7) * 7) * 7
    //(((power(7,0) * 7) * 7) * 7) * 7
    //(((1 * 7) * 7) * 7) * 7
    //((7 * 7) * 7) * 7
    //(49 * 7) * 7
    //343 * 7
    //2401

}
