package com.learn.thinking.generic.simplegenerics.tuple;

import org.junit.Assert;
import org.junit.Test;

public class TupleTest {

    private static class Vehicle {
        private final String id;

        private Vehicle(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Vehicle:" + id;
        }
    }

    @Test
    public void test_twoTuple(){
        TwoTuple<String, Vehicle> twoTuple = new TwoTuple<>("Hello", new Vehicle("01"));
        Assert.assertEquals("(Hello, Vehicle:01)", twoTuple.toString());
    }

    @Test
    public void test_twoTuple_argument_type_inference() {
        TwoTuple<String, Vehicle> twoTuple = TwoTuple.tuple("Hi", new Vehicle("03"));
        Assert.assertEquals("Hi", twoTuple.first);
        Assert.assertEquals("Vehicle:03", twoTuple.second.toString());
    }
}
