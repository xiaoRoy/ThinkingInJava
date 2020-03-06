package com.learn.thinking.enumerated;

import com.learn.thinking.enumerated.basic.Fruit;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.*;

public class EnumAnalysisTest {

    @Test
    public void test_analyze() {
        Set<String> exploreMethods = EnumAnalysis.analyze(EnumAnalysis.Explore.class);
        Set<String> enumMethods = EnumAnalysis.analyze(Enum.class);
        Assert.assertTrue(exploreMethods.containsAll(enumMethods));
    }

    @Test
    public void test_upCastToEnum() {
        Enum<?> aEnum = EnumAnalysis.Explore.HERE;
        Enum[] valuesOfExplore = aEnum.getClass().getEnumConstants();
        Assert.assertEquals(2, valuesOfExplore.length);
        Assert.assertArrayEquals(EnumAnalysis.Explore.values(), valuesOfExplore);
    }

    @Test
    public void test_FruitNext() {
        Fruit apple = Fruit.APPLE;
        boolean hasFruit = Arrays.asList(Fruit.values()).contains(apple.next());
        Assert.assertTrue(hasFruit);
    }
}
