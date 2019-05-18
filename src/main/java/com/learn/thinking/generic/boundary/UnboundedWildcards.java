package com.learn.thinking.generic.boundary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UnboundedWildcards {

    public void showItems(List<Object> list) {
        for(Object item: list) {
            System.out.println(item);
        }
    }

    public void showItemsWithUnboundedWildcard(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    private void doShowItems() {
        List<Integer> numbers = Arrays.asList(1, 3, 44, 2);
        List<Object> objects = new ArrayList<>();
        objects.add(new Object());
        showItemsWithUnboundedWildcard(numbers);
        showItemsWithUnboundedWildcard(objects);

        // only object works
        showItems(objects);
//        showItems(numbers);// compile error
    }
}
