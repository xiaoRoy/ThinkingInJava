package com.learn.thinking.concurrency.misc.catchingexception;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class CaptureExceptionFromThread {

    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool(new HandlerThreadFactory());
        executor.execute(new ExceptionThread());
    }

    private static class HandlerThreadFactory implements ThreadFactory{
        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setUncaughtExceptionHandler(new FirstUncaughtExceptionHandler());
            return thread;
        }
    }

    private static class FirstUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
        @Override
        public void uncaughtException(Thread thread, Throwable throwable) {
            System.out.format("Exception message: %1$s form thread: %2$s", throwable.getMessage(), thread.getName());
        }
    }
}
