package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public class Main {

    public static void main(String[] args) {







        //Semaphore
        //CountdownLatch
        //Exchanger
        //CyclicBarrier
        //Phaser





    }

    private static void countDownLatch() {
        CountDownLatch counter = new CountDownLatch(5);
        new Runner(counter, "Barak");
        new Runner(counter, "Chaky");
        new Runner(counter, "Ivgenia");

        System.out.println("starting the count down");
        long count = counter.getCount();
        while (count > 0){
            try {
                Thread.sleep(1000);
                System.out.println("count="+count);
                if(count == 1){
                    System.out.println("start");
                }

                counter.countDown();
                count = counter.getCount();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void semaphoreExample() {
        Semaphore machines = new Semaphore(2);

        new Person(machines, "Chaky");
        new Person(machines, "Barak");
        new Person(machines, "Ivgenia");
        new Person(machines, "Hadar");
    }
}


class Person extends Thread{

    private Semaphore semaphore;

    public Person(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.setName(name);
        this.start();
    }

    @Override
    public void run() {
        try{
            System.out.println(getName() + " is waiting for ATM machine");
            semaphore.acquire();
            System.out.println(getName() + " is accessing the ATM machine");
            Thread.sleep(1000);
            System.out.println(getName() + " is done using the ATM machine");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Runner extends Thread{
    private CountDownLatch timer;

    public Runner(CountDownLatch timer, String name) {
        this.timer = timer;
        setName(name);
        System.out.println(this.getName() +  " ready and waiting for countdown");
        start();
    }

    @Override
    public void run() {
        try{
            timer.await();
        } catch (InterruptedException e) {
            System.out.println("can't start race");
        }
        System.out.println(getName() + " started running");
    }
}