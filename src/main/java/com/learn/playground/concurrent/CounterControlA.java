package com.learn.playground.concurrent;

public class CounterControlA {

    final private Counter counter;

    public CounterControlA(Counter counter) {
        this.counter = counter;
    }

    public void add(){
        //remove the synchronized or change the lock will cause thread issue
        //we can't use this here, but we can use String.class. The best choice is use counter
        synchronized (counter){
            counter.increase();
        }
    }
}
