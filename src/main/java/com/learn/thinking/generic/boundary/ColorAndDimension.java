package com.learn.thinking.generic.boundary;

public class ColorAndDimension {

    static class Color {
    }

    interface HasColor {
        Color getColor();
    }

    private static class Colored<T extends HasColor> {
        private T item;

        private Colored(T item) {
            this.item = item;
        }

        private Color color() {
            return item.getColor();
        }
    }

    static class Dimension {
        int x, y, z;
    }

}
