package com.learn.thinking.generic.erasure;

public class Factory<T> {
    private T t;
    public <F extends IFactory<T>> Factory(F factory) {
        t = factory.create();
    }

    private static class IntegerFactory implements IFactory<Integer> {
        @Override
        public Integer create() {
            return 0;
        }
    }
}
