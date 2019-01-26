package com.learn.thinking.concurrency.sharingresources;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {

    private ReentrantLock lock = new ReentrantLock();

    public void unTimed(){
        boolean captured = lock.tryLock();
        try {
            System.out.println("unTimed.tryLock.captured:" + captured);
        }finally {
            if(captured){
                lock.unlock();
            }
        }
    }

    public void timed(){
        boolean captured = false;
        try {
           captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
        try {
            System.out.println("Timed.tryLock.captured:" + captured);
        }finally {
            if(captured){
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        final AttemptLocking attemptLocking = new AttemptLocking();
        new Thread(){
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                attemptLocking.lock.lock();
                System.out.println("acquired lock in thread:" +  Thread.currentThread().getName());
            }
        }.start();
        Thread.yield();
        attemptLocking.unTimed();
        attemptLocking.timed();
    }
}
