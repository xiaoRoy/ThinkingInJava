package com.learn.playground.concurrent;

import java.util.concurrent.TimeUnit;


/*
* To demonstrate how synchronized statement(block) works.
* Thread need to acquire a lock before proceed into a synchronized block
* no matter where this block located(in the same class or not)
* */
public class Counter {

    public static final int MAXIMUM_COUNT = 10000;

    private int count;

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increase(){
        count ++;
    }

    public void decrease(){
        count --;
    }

    public static void main(String[] args) {
        Counter counter = new Counter(0);
        CounterControlA counterControlA = new CounterControlA(counter);
        CounterControlB counterControlB = new CounterControlB(counter);
        final Runnable runnableA = new Runnable() {
            @Override
            public void run() {
                for(int index = 0; index < MAXIMUM_COUNT; index ++){
                    counterControlA.add();
                }
            }
        };
        final Runnable runnableB = new Runnable() {
            @Override
            public void run() {
                for(int index = 0; index < MAXIMUM_COUNT; index ++){
                    counterControlB.minus();
                }
            }
        };
        Thread threadA = new Thread(runnableA);
        Thread threadB = new Thread(runnableB);
        threadA.start();
        threadB.start();
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println(counter.getCount());
    }
}
