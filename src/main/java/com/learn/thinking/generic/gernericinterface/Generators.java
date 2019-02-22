package com.learn.thinking.generic.gernericinterface;

import java.util.Collection;

public class Generators {

    private Generators() {
    }

    public static <T> Collection<T> fill(Collection<T> container, Generator<T> generator, int count) {
        for(int index = 0; index < count; index ++) {
            container.add(generator.next());
        }
        return  container;
    }
}
