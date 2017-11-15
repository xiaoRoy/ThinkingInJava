package com.learn.thinking.concurrency.sharingresources;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicEvenGenerator extends IntGenerator {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public int next() {
        return atomicInteger.getAndAdd(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
