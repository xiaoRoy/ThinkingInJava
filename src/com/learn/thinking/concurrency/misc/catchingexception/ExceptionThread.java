package com.learn.thinking.concurrency.misc.catchingexception;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        System.out.println("about to throw new exception");
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new ExceptionThread());
        executorService.shutdown();
    }
}
