package com.learn.thinking.generic.gernericinterface;

public class Fibonacci implements Generator<Integer>{

    private int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int number) {
        int result;
        if(number < 2) {
            result = 1;
        } else {
            result = fib(number - 2) + fib(number -1);
        }
        return result;
    }
}
