package com.company;

public class Main {

    public static void main(String[] args) {
        Cat c = new Cat(){
            @Override
            public int func() {
                return 2;
            }
        };
        Cat c2 = new Cat(){
            @Override
            public int func() {
                return stupidFunc();
            }
            public int stupidFunc(){
                return 2;
            }
        };
        System.out.println(c.func());
    }
}
