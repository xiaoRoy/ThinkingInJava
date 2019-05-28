package com.learn.thinking.generic.boundary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class NaturalNumber {

    private int value;

    NaturalNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private static class EvenNumber extends NaturalNumber {
        public EvenNumber(int value) {
            super(value);
        }
    }

    private void what() {
        List<EvenNumber> evenNumberList = new ArrayList<>();
        List<? extends NaturalNumber> numbers = evenNumberList;


        //add null
        numbers.add(null);

        //invoke clear
        numbers.clear();

        //Get the iterator and invoke null
        Iterator<? extends NaturalNumber> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
        }

        //capture the wildcard and write elements that you've read from the list.
        if (!numbers.isEmpty()) {
            numbers.get(0).setValue(0);
        }

    }


}
