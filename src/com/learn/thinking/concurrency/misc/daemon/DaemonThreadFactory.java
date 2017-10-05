package com.learn.thinking.concurrency.misc.daemon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for(int count = 0; count < 5; count ++){
            executorService.execute(new SimpleDaemon());
        }
        executorService.shutdown();
        TimeUnit.SECONDS.sleep(5);
    }
}
