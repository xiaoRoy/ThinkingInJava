package com.learn.thinking.generic.simplegenerics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomList<T> {
    private List<T> list = new ArrayList<>();
    private Random random = new Random();

    public void add(T item) {
        list.add(item);
    }

    public T select() {
        return list.get(random.nextInt(list.size()));
    }
}
