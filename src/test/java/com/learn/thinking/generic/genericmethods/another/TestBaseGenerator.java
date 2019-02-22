package com.learn.thinking.generic.genericmethods.another;

import com.learn.thinking.generic.gernericinterface.BasicGenerator;
import org.junit.Test;

public class TestBaseGenerator {


    //Caused by: java.lang.IllegalAccessException
    @Test(expected = RuntimeException.class)
    public void test_new_instance_illegal_access () {
        BasicGenerator.create(Cat.Color.class).next();
    }
}
