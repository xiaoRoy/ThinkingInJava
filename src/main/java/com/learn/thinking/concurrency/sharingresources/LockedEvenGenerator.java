package com.learn.thinking.concurrency.sharingresources;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedEvenGenerator extends IntGenerator {

    private int currentValue;

    private final Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try{
            ++ currentValue;
            Thread.yield();
            ++ currentValue;
            return currentValue;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new LockedEvenGenerator());
    }
}
