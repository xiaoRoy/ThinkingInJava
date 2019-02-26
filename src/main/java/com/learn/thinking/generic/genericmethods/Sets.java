package com.learn.thinking.generic.genericmethods;

import java.util.HashSet;
import java.util.Set;

public class Sets {

    public static <T> Set<T> union(Set<T> one, Set<T> another) {
        Set<T> result = new HashSet<>(one);
        result.addAll(another);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> one, Set<T> another) {
        Set<T> result = new HashSet<>(one);
        result.retainAll(another);
        return result;
    }

    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> result = new HashSet<>(superset);
        result.removeAll(subset);
        return result;
    }

    public static <T> Set<T> absoluteComplement(Set<T> one, Set<T> another){
        return difference(union(one, another), one);
    }

    public static <T> Set<T> relativeComplement(Set<T> one, Set<T> another) {
        return difference(another, one);
    }
}
