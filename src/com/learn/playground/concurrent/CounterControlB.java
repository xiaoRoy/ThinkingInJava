package com.learn.playground.concurrent;

public class CounterControlB {

    private final Counter counter;

    public CounterControlB(Counter counter) {
        this.counter = counter;
    }

    public void minus(){
        synchronized (counter){
            counter.decrease();
        }
    }

}
