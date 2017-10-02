package com.learn.thinking.concurrency.executor;

import com.learn.thinking.concurrency.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int count = 0; count < 5 ; count ++){
            executorService.execute(new LiftOff());
        }
    }
}
