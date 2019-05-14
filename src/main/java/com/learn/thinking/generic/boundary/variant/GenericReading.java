package com.learn.thinking.generic.boundary.variant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenericReading {

    private List<Holder.Apple> apples = Collections.singletonList(new Holder.Apple());
    private List<Holder.Fruit> fruits = Collections.singletonList(new Holder.Fruit());

    static <T> T readFirstOneExact(List<T> list) {
        return list.get(0);
    }

    private void getApple() {
        Holder.Apple apple = readFirstOneExact(apples);
        Holder.Fruit fruit = readFirstOneExact(fruits);
        fruit = readFirstOneExact(apples);
    }

    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    private void cannotGetApple() {
        Reader<Holder.Fruit> fruitReader = new Reader<>();
        Holder.Fruit fruit = fruitReader.readExact(fruits);

//        Holder.Fruit anotherFruit = fruitReader.readExact(apples);
    }

    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    private void getAppleCovariant() {
        CovariantReader<Holder.Fruit> fruitCovariantReader =
                new CovariantReader<>();
        Holder.Fruit fruit = fruitCovariantReader.readCovariant(fruits);
        Holder.Fruit anotherFruit = fruitCovariantReader.readCovariant(apples);
    }
}
