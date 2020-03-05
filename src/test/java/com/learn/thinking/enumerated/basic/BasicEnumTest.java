package com.learn.thinking.enumerated.basic;

import org.junit.Assert;
import org.junit.Test;

public class BasicEnumTest {

    @Test
    public void test_enum_toString() {
        Spiciness howHot = Spiciness.MEDIUM;
        Assert.assertEquals("MEDIUM", howHot.toString());
    }

    @Test
    public void test_enumOrigin() {
        Spiciness[] values = Spiciness.values();
        for(int index = 0, length = values.length; index < length; index ++) {
            Assert.assertEquals(index, values[index].ordinal());
        }
    }

    @Test
    public void test_burrito_describe(){
        Burrito burrito = new Burrito(Spiciness.MEDIUM);
        Assert.assertEquals("a little hot", burrito.describe());
    }

    @Test
    public void test_enum_compareTo() {
        Assert.assertEquals(-1, Shrubbery.CRAWLING.compareTo(Shrubbery.HANGING));
        Assert.assertEquals(1, Shrubbery.CRAWLING.compareTo(Shrubbery.GROUND));
    }

    @Test
    public void test_enum_equals() {
        Assert.assertNotEquals(Shrubbery.CRAWLING, Shrubbery.GROUND);
        Assert.assertEquals(Shrubbery.CRAWLING, Shrubbery.CRAWLING);
    }

    @Test
    public void test_enum_equalsOperator() {
        Assert.assertNotSame(Shrubbery.CRAWLING, Shrubbery.GROUND);
        Assert.assertSame(Shrubbery.HANGING, Shrubbery.HANGING);
    }

    @Test
    public void test_enum_getDeclaringClass () {
        Assert.assertEquals(Shrubbery.HANGING.getDeclaringClass(), Shrubbery.class);
        Assert.assertEquals(Shrubbery.GROUND.getDeclaringClass(), Shrubbery.class);
    }

    @Test
    public void test_enum_name() {
        Assert.assertEquals("GROUND", Shrubbery.GROUND.name());
        Assert.assertEquals("CRAWLING", Shrubbery.CRAWLING.name());
    }

    @Test
    public void text_enum_valueOf() {
        Shrubbery hanging = Enum.valueOf(Shrubbery.class, "HANGING");
        Assert.assertSame(Shrubbery.HANGING, hanging);

        Shrubbery crawling = Shrubbery.valueOf(Shrubbery.class, "CRAWLING");
        Assert.assertSame(Shrubbery.CRAWLING, crawling);

        Shrubbery ground = Shrubbery.valueOf("GROUND");
        Assert.assertSame(Shrubbery.GROUND, ground);
    }

    @Test
    public void test_coinsValue() {
        Assert.assertEquals(1, Coin.PENNY.getCents());
        Assert.assertEquals(5, Coin.NICKEL.getCents());
        Assert.assertEquals(10, Coin.DIME.getCents());
        Assert.assertEquals(25, Coin.QUARTER.getCents());
    }

    @Test
    public void test_coins_toString() {
        Assert.assertEquals("1 cent", Coin.PENNY.toString());
        Assert.assertEquals("5 cents", Coin.NICKEL.toString());
        Assert.assertEquals("10 cents", Coin.DIME.toString());
        Assert.assertEquals("25 cents", Coin.QUARTER.toString());
    }
}
