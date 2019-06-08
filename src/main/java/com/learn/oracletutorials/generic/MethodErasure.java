package com.learn.oracletutorials.generic;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class MethodErasure {

    public static <T> int count(@Nullable List<T> list, @Nullable T itemToCount) {
        int result = 0;
        if (list != null) {
            for (T item : list) {
                if (Objects.equals(item, itemToCount)) {
                    result++;
                }
            }
        }
        return result;
    }

    public static int countErased(List list, Object itemToCount) {
        int result = 0;
        if (list != null) {
            for (Object item : list) {
                if (Objects.equals(item, itemToCount)) {
                    result++;
                }
            }
        }
        return result;
    }

    static class Shape {
        static class Circle extends Shape {
        }

        static class Triangle extends Shape {
        }

        static class Rectangle extends Shape {
        }
    }

    public static <T extends Shape> void draw(T shape) {
    }

    public static void drawErased(Shape shape) {
    }


}
