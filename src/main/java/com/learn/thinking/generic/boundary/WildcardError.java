package com.learn.thinking.generic.boundary;

import javax.annotation.Nonnull;
import java.util.List;

public class WildcardError {

    private void switchFirstAndLast(@Nonnull List<?> list) {
        int size = list.size();
        if (size > 1) {
            Object first = list.get(0);
            int lastIndex = size - 1;
            Object last = list.get(lastIndex);
//            list.set(0, last); error
//            list.set(lastIndex, first); error
        }
    }

    private void switchFirstAndLastFixed(@Nonnull List<?> list) {
        int size = list.size();
        if (size > 1) {
            int lastIndex = size - 1;
            switchFirstAndLastFixedCaptureHelper(list, 0);
            switchFirstAndLastFixedCaptureHelper(list, lastIndex);
        }
    }


    private <T> void switchFirstAndLastFixedCaptureHelper(@Nonnull List<T> list, int index) {
        T item = list.get(index);
        int targetIndex = list.size() - 1 - index;
        list.set(targetIndex, item);
    }

}
