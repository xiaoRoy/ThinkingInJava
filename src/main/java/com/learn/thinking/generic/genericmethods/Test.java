package com.learn.thinking.generic.genericmethods;

import com.learn.thinking.generic.gernericinterface.BasicGenerator;

public class Test {

    public static void main(String[] args) {
         BasicGenerator.create(Test.NestedTest.class).next();
    }

    private static class NestedTest {

    }
}
