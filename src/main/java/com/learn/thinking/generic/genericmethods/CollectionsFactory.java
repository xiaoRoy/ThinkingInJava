package com.learn.thinking.generic.genericmethods;

import java.util.*;

public class CollectionsFactory {

    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    public static <T> LinkedList<T> linkedList() {
        return new LinkedList<T>();
    }

    public static <T> Set<T> set() {
        return new HashSet<T>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<T>();
    }

    public static <T> List<T> makeList(T... items) {
        List<T> list = new ArrayList<>();
        for(T item : items) {
            list.add(item);
        }
        return list;
    }

    private static class LimitOfInference {
        static void notWork(Map<String, ? extends Number> count) {}

        public static void main(String[] args) {
            // Does not compile in Java SE 5
            notWork(CollectionsFactory.map());

            notWork(CollectionsFactory.<String, Number>map());
        }
    }
}
