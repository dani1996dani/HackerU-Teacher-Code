package com.company;

import java.util.Random;

public class Main {

    static int myStaticVariable = 3;
    static Cat c = new Cat();
    static Object o = new Object();
    static Random random = new Random(System.nanoTime());

    public static void main(String[] args) {
        example2();


    }

    private static void example2() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                doSomethingSlow(random.nextLong());
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                doSomethingSlow(random.nextLong());
            }
        });
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {

        }

        System.out.println("done");
        System.out.println(c.counter);
    }


    @Deprecated
    public static void myVeryOldAndDeffectiveMethod(){

    }

    public static void doSomethingSlow(long millis){
        for (int i = 0; i < 100; i++) {
            //System.out.println(Thread.currentThread().getName() + " " + i);
            Random random = new Random(millis);
            try {
                synchronized (o) {
                    //Thread.sleep(random.nextInt(20));
                    int x = c.counter;
                    Thread.sleep(random.nextInt(60));
                    c.counter = x + 1;
                    //Thread.sleep(random.nextInt(20));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static void example1() {
        int count = 3;
        /*
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                longRunningTask();
            }
        });
        thread.start();
        */

        MyThread thread = new MyThread(count);
        thread.setName("my cool thread");

        thread.start();
        new Dog();
        thread.stopChecking();
        System.out.println("line after long running task");
    }

    static void longRunningTask(){
        Thread currentThread = Thread.currentThread();
        if(currentThread.getName().equals("my cool thread")){

        }
        if(currentThread instanceof  MyThread) {
            MyThread myThread = (MyThread) currentThread;
        }

        /*int x = 0;
        for (int i = 0; i < 100000000; i++) {
            x++;
            if(x % 3 == 0)
                x--;
            for (int j = 0; j < 500; j++) {
                x += 3;
            }
        }*/
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done running long running task");
    }





    static  class Cat {
        String name;
        int counter;
        public void increment(){
            synchronized (this) {
                counter++;
            }
        }
    }



}
