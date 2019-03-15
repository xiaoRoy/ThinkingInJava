package com.learn.thinking.generic.earsure.array;

public class GenericArray<T> {

    private T[] array;

    public GenericArray(int size) {
        this.array = (T[])new Object[size];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index){
        return array[index];
    }

    public T[] array() {
        return array;
    }

}
