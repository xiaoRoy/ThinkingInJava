package com.learn.thinking.generic.boundary.variant;

import java.util.List;

public class GenericWriting {

    public <T> void addExactTypeItem(List<T> list, T item) {
        list.add(item);
    }

    public <T> void addWithSuperWildcard(List<? super T> list, T item) {
        list.add(item);
    }
}
