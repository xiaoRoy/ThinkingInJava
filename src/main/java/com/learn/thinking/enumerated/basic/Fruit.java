package com.learn.thinking.enumerated.basic;


import com.learn.thinking.generic.gernericinterface.Generator;

import javax.annotation.Nonnull;
import java.util.Random;

public enum Fruit implements Generator<Fruit> {
    APPLE, PEAR, ORANGE, BANANA, PEACH;

    @Nonnull
    private Random random = new Random();

    @Nonnull
    @Override
    public Fruit next() {
        int count = values().length;
        return values()[random.nextInt(count)];
    }
}
