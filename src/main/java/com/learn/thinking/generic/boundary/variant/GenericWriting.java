package com.learn.thinking.generic.boundary.variant;

import java.util.ArrayList;
import java.util.List;

public class GenericWriting {

    public static <T> void addExactTypeItem(List<T> list, T item) {
        list.add(item);
    }

    public static void addApple(List<Holder.Fruit> list, Holder.Apple item) {
        list.add(item);
    }

    public static <T> void addWithSuperWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    private void addApple() {
        List<Holder.Apple> apples = new ArrayList<>();
        List<Holder.Fruit> fruits = new ArrayList<>();

        addExactTypeItem(apples, new Holder.Apple());
        addWithSuperWildcard(apples, new Holder.Apple());

        addExactTypeItem(fruits, new Holder.Apple());
        addWithSuperWildcard(fruits, new Holder.Apple());
    }
}
