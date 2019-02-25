package com.learn.thinking.generic.simplegenerics.tuple;

public class TwoTuple<A, B> {

    public final A first;
    public final B second;

    public static <A, B> TwoTuple<A, B> tuple(A first, B second) {
        return new TwoTuple<>(first, second);
    }

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
