package com.learn.thinking.enumerated;

import com.learn.thinking.enumerated.basic.Coin;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class EnumRandomSelectionTest {

    @Test
    public void test_randomByValues() {
        Coin[] coinValues = Coin.values();
        Coin coin = EnumRandomSelection.random(coinValues);
        boolean hasCoin = Arrays.asList(coinValues).contains(coin);
        assertTrue(hasCoin);
    }

    @Test
    public void test_randomByClass() {
        Coin coin = EnumRandomSelection.random(Coin.class);
        boolean hasCoin = Arrays.asList(Coin.values()).contains(coin);
        assertTrue(hasCoin);
    }

    @Test
    public void test_randomByClass_null() {
        What what = EnumRandomSelection.random(What.class);
        assertNull(what);
    }

    private enum What{}

}
