package com.learn.thinking.generic.erasure.array;

import java.lang.reflect.Array;

public class GenericArrayWithTypeToken<T> {

    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type, size);
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
