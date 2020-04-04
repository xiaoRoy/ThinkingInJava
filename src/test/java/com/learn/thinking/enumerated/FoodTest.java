package com.learn.thinking.enumerated;

import org.junit.Assert;
import org.junit.Test;

public class FoodTest {

    @Test
    public void test_allIsFood() {
        Assert.assertTrue(Course.Food.Appetizer.SALAD instanceof Course.Food);
        Assert.assertTrue(Course.Food.MainCourse.LASAGNE instanceof Course.Food);
        Assert.assertTrue(Course.Food.Dessert.TIRAMISU instanceof Course.Food);
        Assert.assertTrue(Course.Food.Coffee.LATTE instanceof Course.Food);
    }

}
