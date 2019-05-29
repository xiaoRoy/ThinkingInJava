package com.learn.thinking.generic.erasure.array;

public class ArrayOfGenericReference {

    private Generic<Integer>[] genericIntegerArray;

    public ArrayOfGenericReference() {
        genericIntegerArray = (Generic<Integer>[])new Generic[4];
        genericIntegerArray[0] = new Generic<Integer>();
    }

    private static class Generic<T> {}
}
