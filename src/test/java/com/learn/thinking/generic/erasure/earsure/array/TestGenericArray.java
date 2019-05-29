package com.learn.thinking.generic.erasure.earsure.array;

import com.learn.thinking.generic.erasure.array.GenericArray;
import com.learn.thinking.generic.erasure.array.GenericArraySecond;
import com.learn.thinking.generic.erasure.array.GenericArrayWithTypeToken;
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

    @Test(expected = ClassCastException.class)
    public void test_array_second() {
        GenericArraySecond<Integer> integerGenericArray = new GenericArraySecond<>(4);
        Integer[] result = integerGenericArray.array();
    }

    @Test
    public void test_array_withTypeToken() {
        GenericArrayWithTypeToken<Integer> integerGenericArray = new GenericArrayWithTypeToken<>(Integer.class, 4);
        Integer[] result = integerGenericArray.array();
        Assert.assertEquals(4, result.length);
    }
}
