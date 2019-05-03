package com.learn.thinking.generic.earsure.array;

public class ArrayOfGenericReference {

    private static class Generic<T> {}

    private Generic<Integer>[] genericIntegerArray;

    public ArrayOfGenericReference() {
        genericIntegerArray = (Generic<Integer>[])new Generic[4];
        genericIntegerArray[0] = new Generic<Integer>();
    }

}
