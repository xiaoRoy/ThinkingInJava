package com.learn.thinking.generic.boundary.variant;

public class Holder<T> {

    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    static class Fruit {
    }

    static class Apple extends Fruit{
    }

    static class RedApple extends Apple{
    }

    static class Orange extends Fruit{
    }
}
