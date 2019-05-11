package com.learn.thinking.generic.boundary.variant;

import org.junit.Test;

import static org.junit.Assert.*;

public class CovariantGenericTest {

    @Test(expected = ClassCastException.class)
    public void getOrangeFromHolder() {
        Holder<Holder.Apple> appleHolder = new Holder<>();
        appleHolder.setItem(new Holder.Apple());
        new CovariantGeneric().getOrangeFromHolder(appleHolder);
    }
}
