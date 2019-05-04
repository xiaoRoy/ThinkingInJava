package com.learn.thinking.generic.boundary;

public class Bounded extends ColorAndDimension.Dimension implements ColorAndDimension.HasColor{

    @Override
    public ColorAndDimension.Color getColor() {
        return new ColorAndDimension.Color();
    }
}
