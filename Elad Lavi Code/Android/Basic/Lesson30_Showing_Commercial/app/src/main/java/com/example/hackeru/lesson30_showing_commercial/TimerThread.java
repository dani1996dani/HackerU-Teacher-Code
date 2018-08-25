package com.example.hackeru.lesson30_showing_commercial;

public class TimerThread extends Thread {

    private int counter = 0;
    private int numberOfSecondsToLaunch;
    private boolean go;
    private TimerListener listener;
    private boolean repeat;


    public TimerThread(int numberOfSecondsToLaunch, TimerListener listener, boolean repeat) {
        this.numberOfSecondsToLaunch = numberOfSecondsToLaunch;
        this.listener = listener;
        this.repeat = repeat;
        go = true;
        counter = 0;
    }


    public void reset(){
        counter = 0;
    }

    public void stopTimer(){
        go = false;
        interrupt();
    }

    @Override
    public void run() {
        while (go){
            counter++;
            if(listener != null)
                listener.onTick(counter);
            if(counter == numberOfSecondsToLaunch){
                if(listener != null)
                    listener.onTimer();
                counter = 0;
                if(!repeat){
                    break;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }

    public interface TimerListener{
        void onTimer();
        void onTick(final int counter);
    }
}
