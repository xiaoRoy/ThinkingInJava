package com.learn.thinking.concurrency.misc.daemon;

import java.util.concurrent.TimeUnit;

public class FinallyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Stated.");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException exception) {
            System.out.println("Existing via InterruptedException");
        } finally {
            System.out.println("This should always run???");
        }
    }

    public static void main(String[] args) {
        new DaemonThreadPoolExecutor().execute(new FinallyRunnable());
    }
}
