package com.learn.thinking.generic.genericmethods;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestSets {

    @Test
    public void test_absoluteComplement() {
        Set<Integer> one = new HashSet<>(Arrays.asList(1, 4, 5, 7));
        Set<Integer> another = new HashSet<>(Arrays.asList(5, 7, 8, 9));
        Set<Integer> expected = new HashSet<>(Arrays.asList(8, 9));
        Assert.assertEquals(expected, Sets.absoluteComplement(one, another));
    }

    @Test
    public void test_relativeComplement() {
        Set<Integer> one = new HashSet<>(Arrays.asList(1, 4, 5, 7));
        Set<Integer> another = new HashSet<>(Arrays.asList(5, 7, 8, 9));
        Set<Integer> expected = new HashSet<>(Arrays.asList(8, 9));
        Assert.assertEquals(expected, Sets.relativeComplement(one, another));
    }
}
