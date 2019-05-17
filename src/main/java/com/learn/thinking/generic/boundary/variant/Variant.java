package com.learn.thinking.generic.boundary.variant;

public class Variant {

    public static <T> void contravariant(Contravariant<? super T> contravariant, T t) {
        contravariant.setT(t);
    }

    public static <T> T covariant(Covariant<? extends T> covariant) {
        return covariant.getT();
    }
}
