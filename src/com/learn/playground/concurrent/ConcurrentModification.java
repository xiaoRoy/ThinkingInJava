package com.learn.playground.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class ConcurrentModification {

    public static void main(String[] args) {
        List<Integer> numbers = new Vector<>();
        numbers.addAll(Arrays.asList(1, 2, 3, 4, 5));
        Thread threadIterate = new Thread(() -> iterateList(numbers));
        Thread threadAdd = new Thread(() -> addNumber(numbers));
        threadIterate.start();
        threadAdd.start();
    }

    private static void iterateList(List<Integer> numbers) {
        /*
        * acquire the the lock of vector(numbers) here,
        * so method addNumber() numbers.add(310) can't process
        * because it can't get the lock which acquired by this method.
        * */
        synchronized (numbers) {
            System.out.println("enter");
            for (int number : numbers) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                System.out.println(number);
            }

        }
    }

    private static void addNumber(List<Integer> numbers) {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println("add.before");
        numbers.add(310);
        System.out.println("add.after");
    }
}
