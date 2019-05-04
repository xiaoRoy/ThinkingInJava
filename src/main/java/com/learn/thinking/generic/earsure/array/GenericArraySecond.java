package com.learn.thinking.generic.earsure.array;

public class GenericArraySecond<T> {

    private Object[] array;

    public GenericArraySecond(int size) {
        array = new Object[size];
    }

    public void put(int index, T t) {
        array[index] = t;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    public T[] array() {
        return (T[])array;
    }

}
