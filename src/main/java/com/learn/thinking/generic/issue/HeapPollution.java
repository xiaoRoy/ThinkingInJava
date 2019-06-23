package com.learn.thinking.generic.issue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapPollution {

    private void doHeapPollution() {
        List<String> stringListA = new ArrayList<>();
        List<String> stringListB = new ArrayList<>();

        ArrayBuilder.addToList(stringListA, "one", "two", "three");
        ArrayBuilder.addToList(stringListB, "four", "five", "six");

        List<List<String>> listOfStringList = new ArrayList<>();
        ArrayBuilder.addToList(listOfStringList, stringListA, stringListB);

        ArrayBuilder.faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!"));
    }

    static class ArrayBuilder {
        static <T> void addToList(List<T> list, T... elements) {
            for (T item : elements) {
                list.add(item);
            }
        }

        static <T> void addToListInJVMPerspective(List<T> list, Object[] elements) {
            for (Object item : elements) {
                list.add((T)item);
            }
        }

        static void addToListErased(List list, Object[] elements) {
            for (Object item : elements) {
                list.add(item);
            }
        }

        static <T> void addItemToList(List<T> list, T item) {
            list.add(item);
        }

        static void faultyMethod(List<String>... stringArray) {
            Object[] objectArray = stringArray;
            objectArray[0] = Arrays.asList(42);
            //ClassCastException thrown here
            String item = stringArray[0].get(0);
        }
    }
}
