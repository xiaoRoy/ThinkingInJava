package com.learn.thinking.generic.erasure;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArrayMaker<T> {

    final private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    T[] create(int size) {
        //run time
        return (T[]) Array.newInstance(kind, size);
    }

    private static class FilledListMaker<T> {

        /*
        * Even though the compiler is unable to know anything about T inside create( ),
        * it can still ensure at compile time—that what you put into result is of type T,
        * so that it agrees with ArrayList<T>.
        * */
        List<T> create(T t, int size) {
            List<T> result = new ArrayList<>();
            for (int index = 0; index < size; index++) {
                result.add(t);
            }
            return result;
        }
    }
}
