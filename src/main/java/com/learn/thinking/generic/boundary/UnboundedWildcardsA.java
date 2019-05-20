package com.learn.thinking.generic.boundary;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcardsA {

    private List rawList;
    private List<?> unboundedList;
    private List<? extends Number> upperBoundedList;

    public void assignWithRaw(List list) {
        rawList = list;
        unboundedList = list;
        upperBoundedList = list;//unchecked assignment
    }

    public void assignWithUnbounded(List<?> list) {
        rawList = list;
        unboundedList = list;
//        upperBoundedList = list;
    }

    public void assignWithUpperBounded(List<? extends Number> list) {
        rawList = list;
        unboundedList = list;
        upperBoundedList = list;
    }

    private void doAssign() {
        List rawList = new ArrayList();
        assignWithRaw(rawList);
        assignWithUnbounded(rawList);
        assignWithUpperBounded(rawList);//unchecked assignment

        List<?> unboundedList = new ArrayList<>();
        //You can only insert null into a List<?>.
//        unboundedList.add(null);
        assignWithRaw(unboundedList);
        assignWithUnbounded(unboundedList);
//        assignWithUpperBounded(unboundedList);

        List<Integer> numbers = new ArrayList<>();
        assignWithRaw(numbers);
        assignWithUnbounded(numbers);
        assignWithUpperBounded(numbers);

    }

}
