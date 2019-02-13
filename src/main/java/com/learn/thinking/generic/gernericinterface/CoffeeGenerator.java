package com.learn.thinking.generic.gernericinterface;

import com.learn.thinking.generic.model.Coffee;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private static Random sRandom = new Random();

    private int size;

    private Class[] types = {Coffee.Latte.class, Coffee.Mocha.class,
            Coffee.Cappuccino.class, Coffee.Americano.class, Coffee.Breve.class};

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    public CoffeeGenerator() {
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[sRandom.nextInt(types.length)].newInstance();
        } catch (InstantiationException | IllegalAccessException exception) {
            throw new RuntimeException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    private class CoffeeIterator implements Iterator<Coffee> {

        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count --;
            return CoffeeGenerator.this.next();
        }
    }
}
