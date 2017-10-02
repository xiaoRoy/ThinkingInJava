package com.learn.thinking.concurrency.executor;

import com.learn.thinking.concurrency.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {
    public static void main(String[] args) {
        new TestThreadPool().testSingleThreadPool(new LiftOff());
    }

    private void testCachedThreadPool(Runnable runnable){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int count = 0; count < 5 ; count ++){
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }

    private void testFixedThreadPool(Runnable runnable){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int count = 0; count < 5 ; count ++){
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }

    private void testSingleThreadPool(Runnable runnable){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int count = 0; count < 5 ; count ++){
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }
}
