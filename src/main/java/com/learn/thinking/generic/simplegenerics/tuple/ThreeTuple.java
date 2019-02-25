package com.learn.thinking.generic.simplegenerics.tuple;

public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {

    public static <A, B, C> ThreeTuple<A, B, C> threeTuple(A first, B second, C third) {
        return new ThreeTuple<>(first, second, third);
    }

    public final C third;

    public ThreeTuple(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third +")";
    }
}
