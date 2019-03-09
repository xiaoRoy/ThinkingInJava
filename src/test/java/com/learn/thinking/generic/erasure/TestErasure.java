package com.learn.thinking.generic.erasure;

import com.learn.thinking.generic.earsure.ClassTypeCapture;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestErasure {

    @Test
    public void test_erasedTypeEquivalence() {
        Class classOne = new ArrayList<Integer>().getClass();
        Class classAnother = new ArrayList<String>().getClass();
        Assert.assertEquals(classOne, classAnother);
    }

    @Test
    public void test_typeParameters() {
        List<Animal> animals = new ArrayList<>();
        TypeVariable<? extends Class<? extends List>>[] typeParameters = animals.getClass().getTypeParameters();
        Assert.assertEquals("E", typeParameters[0].toString());
    }

    @Test
    public void test_isInstance() {
        ClassTypeCapture<Animal> capture = new ClassTypeCapture<>(Animal.class);
        Assert.assertTrue(capture.isKind(new Animal()));
    }

    private class Animal {

    }
}
