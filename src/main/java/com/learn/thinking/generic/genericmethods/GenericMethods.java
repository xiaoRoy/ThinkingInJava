package com.learn.thinking.generic.genericmethods;

public class GenericMethods {

    public <T> void what(T t) {
        System.out.println(t.getClass().getName());
    }
}
