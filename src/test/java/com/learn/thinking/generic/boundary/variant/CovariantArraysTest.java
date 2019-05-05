package com.learn.thinking.generic.boundary.variant;

import org.junit.Test;

public class CovariantArraysTest {


    @Test(expected = ArrayStoreException.class)
    public void test_storeFruit_arrayStoreException() {
        Holder.Fruit[] fruits = new Holder.Apple[10];
        fruits[0] = new Holder.Apple();
        fruits[1] = new Holder.RedApple();

        fruits[2] = new Holder.Fruit();
    }

    @Test(expected = ArrayStoreException.class)
    public void test_storeOrange_arrayStoreException() {
        Holder.Fruit[] fruits = new Holder.Apple[10];
        fruits[0] = new Holder.Apple();
        fruits[1] = new Holder.RedApple();

        fruits[2] = new Holder.Orange();
    }
}
