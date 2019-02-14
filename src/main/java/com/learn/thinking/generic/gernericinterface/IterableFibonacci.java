package com.learn.thinking.generic.gernericinterface;

import java.util.Iterator;

public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {

    private int count;

    public IterableFibonacci(int count) {
        this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public Integer next() {
                count --;
                return IterableFibonacci.this.next();
            }
        };
    }
}
