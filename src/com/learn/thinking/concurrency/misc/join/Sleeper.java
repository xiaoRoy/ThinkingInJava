package com.learn.thinking.concurrency.misc.join;

import java.util.concurrent.TimeUnit;

public class Sleeper extends Thread{

    private int duration;

    public Sleeper(String name, int duration){
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(duration);
            System.out.println(getName() + " has awaken.");
        } catch (InterruptedException exception) {
            System.out.println(getName() + " was interrupted.");
            System.out.println("isInterrupted():" + isInterrupted());
        }
    }
}
