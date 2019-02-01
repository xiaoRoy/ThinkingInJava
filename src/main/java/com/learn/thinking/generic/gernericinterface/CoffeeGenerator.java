package com.learn.thinking.generic.gernericinterface;

import com.learn.thinking.generic.model.Coffee;

import java.util.Iterator;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    @Override
    public Coffee next() {
        return null;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return null;
    }

    private static class CoffeeIterator implements Iterator<Coffee> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Coffee next() {
            return null;
        }
    }
}
