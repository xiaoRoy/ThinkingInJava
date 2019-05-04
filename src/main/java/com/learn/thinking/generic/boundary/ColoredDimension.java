package com.learn.thinking.generic.boundary;

class ColoredDimension<T extends ColorAndDimension.Dimension & ColorAndDimension.HasColor> {
    private T item;

    public ColoredDimension(T item) {
        this.item = item;
    }

    private ColorAndDimension.Color color() {
        return item.getColor();
    }

    private int x() {
        return item.x;
    }

    private int y() {
        return item.y;
    }

    private int z() {
        return item.z;
    }

    public static void main(String[] args) {
        new ColoredDimension<>(new Bounded());
    }
}
