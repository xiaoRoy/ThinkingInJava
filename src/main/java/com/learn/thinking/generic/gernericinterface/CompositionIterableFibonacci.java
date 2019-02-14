package com.learn.thinking.generic.gernericinterface;

import java.util.Iterator;

public class CompositionIterableFibonacci implements Iterable<Integer>{

    private int count;
    private Fibonacci fibonacci;

    public CompositionIterableFibonacci(int count) {
        this.count = count;
        fibonacci = new Fibonacci();
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
                return fibonacci.next();
            }
        };
    }
}
