package com.company;

public class MyThread extends Thread {

    int count;
    private boolean go = true;
    public MyThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (go){
            //check if file exists
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            //
        }
        /*for (int i = 0; i < count; i++) {
            Main.longRunningTask();
        }*/

    }

    public void stopChecking(){
        go = false;
        this.interrupt();
    }
}
