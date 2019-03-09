package com.learn.thinking.generic.earsure;

public class ClassTypeCapture<T> {

    private final Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean isKind(Object another) {
        return kind.isInstance(another);
    }
}
