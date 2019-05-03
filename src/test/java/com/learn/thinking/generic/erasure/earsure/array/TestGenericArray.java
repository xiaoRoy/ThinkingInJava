package com.learn.thinking.generic.erasure.earsure.array;

import com.learn.thinking.generic.earsure.array.GenericArray;
import org.junit.Assert;
import org.junit.Test;

public class TestGenericArray {

    @Test(expected = ClassCastException.class)
    public void test_array() {
        GenericArray<Integer> integerGenericArray = new GenericArray<>(4);
        Integer[] result = integerGenericArray.array();
    }

    @Test
    public void test_getElementAt() {
        GenericArray<Integer> integerGenericArray = new GenericArray<>(4);
        integerGenericArray.put(1, 4);
        int result = integerGenericArray.get(1);
        Assert.assertEquals(4, result);

    }
}
