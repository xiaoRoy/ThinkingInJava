package com.learn.thinking.generic.erasure.earsure.array;

import com.learn.thinking.generic.earsure.array.GenericArray;
import org.junit.Test;

public class TestGenericArray {

    @Test(expected = ClassCastException.class)
    public void test_array() {
        GenericArray<Integer> integerGenericArray = new GenericArray<>(4);
        Integer[] result = integerGenericArray.array();
    }
}
