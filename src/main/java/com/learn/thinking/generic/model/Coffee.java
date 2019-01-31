package com.learn.thinking.generic.model;

public abstract class Coffee {

    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }

    public static class Latte extends Coffee {

    }

    public static class Mocha extends Coffee {

    }

    public static class Cappuccino extends Coffee {

    }

    public static class Americano extends Coffee {

    }

    public static class Breve extends Coffee {

    }

}
