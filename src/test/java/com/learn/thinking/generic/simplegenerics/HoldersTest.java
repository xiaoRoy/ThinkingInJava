package com.learn.thinking.generic.simplegenerics;

import com.learn.thinking.generic.model.AutoMobile;
import org.junit.Assert;
import org.junit.Test;

public class HoldersTest {

    @Test
    public void test_getContentFromHolderUsingObject() {
        Holders.HolderUsingObject holderUsingObject = new Holders.HolderUsingObject(new AutoMobile());
        Assert.assertTrue(holderUsingObject.getContent() instanceof AutoMobile);
    }

    @Test
    public void test_getContentFromHolderUsingGeneric() {
        Holders.HolderUsingGeneric<AutoMobile>
                holderUsingGeneric = new Holders.HolderUsingGeneric<>(new AutoMobile.FastAutoMobile());
        // allow to put object of that type or the a sub-type
        Assert.assertTrue(holderUsingGeneric.getContent() instanceof AutoMobile.FastAutoMobile);
    }
}
