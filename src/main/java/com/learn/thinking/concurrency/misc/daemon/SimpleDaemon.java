package com.learn.thinking.concurrency.misc.daemon;

import java.util.concurrent.TimeUnit;

public class SimpleDaemon implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println(currentThreadName());
    }

    protected String currentThreadName(){
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        Thread daemon = new Thread(new SimpleDaemon());
        daemon.setDaemon(true);
        daemon.start();
    }
}
