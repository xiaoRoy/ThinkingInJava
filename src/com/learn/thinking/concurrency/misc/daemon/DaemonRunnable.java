package com.learn.thinking.concurrency.misc.daemon;

import java.util.concurrent.TimeUnit;

public class DaemonRunnable implements Runnable{
    private Thread[] threads = new Thread[10];

    @Override
    public void run() {
        final int length = threads.length;
        for (int index = 0; index < length; index ++){
            this.threads[index] = new Thread(new DaemonSpawn());
            this.threads[index].start();
            System.out.println("DaemonSpawn " + index + " started.");
        }
        for(int index = 0; index < length; index ++){
            System.out.println("Thread[" + index + "].isDaemon() = " + threads[index].isDaemon() + ".");
        }
        while (true){
            Thread.yield();
        }
    }

    private static class DaemonSpawn implements Runnable{
        @Override
        public void run() {
            while (true){
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new DaemonThreadPoolExecutor().execute(new DaemonRunnable());
        TimeUnit.SECONDS.sleep(3);
    }
}
