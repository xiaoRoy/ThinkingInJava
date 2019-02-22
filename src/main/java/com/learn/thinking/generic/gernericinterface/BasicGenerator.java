package com.learn.thinking.generic.gernericinterface;

public class BasicGenerator<T> implements Generator<T>{

    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            // Assumes type is a public class:
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }
}
