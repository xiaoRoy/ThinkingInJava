package com.learn.thinking.generic.boundary.variant;

public class Covariant<T> {
    private T t;

    public Covariant(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
