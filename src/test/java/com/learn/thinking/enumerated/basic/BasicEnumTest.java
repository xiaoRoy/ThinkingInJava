package com.learn.thinking.enumerated.basic;

import org.junit.Assert;
import org.junit.Test;

public class BasicEnumTest {

    @Test
    public void test_enumToString() {
        Spiciness howHot = Spiciness.MEDIUM;
        Assert.assertEquals("MEDIUM", howHot.toString());
    }

    @Test
    public void test_enumOrigin() {
        Spiciness[] values = Spiciness.values();
        for(int index = 0, length = values.length; index < length; index ++) {
            Assert.assertEquals(index, values[index].ordinal());
        }
    }

    @Test
    public void test_burrito_describe(){
        Burrito burrito = new Burrito(Spiciness.MEDIUM);
        Assert.assertEquals("a little hot", burrito.describe());
    }
}
