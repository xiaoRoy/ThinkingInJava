package com.learn.thinking.generic.boundary.variant;


import java.util.ArrayList;
import java.util.List;

import com.learn.thinking.generic.boundary.variant.Holder.Apple;
import com.learn.thinking.generic.boundary.variant.Holder.RedApple;

public class SuperTypeWildcards {

    private List<? super Apple> appleList = new ArrayList<>();

    private Holder<? super Apple> appleHolder = new Holder<>();

    public SuperTypeWildcards() {
        //List<Apple> is subtype of List<? super Apple>
        // subtype is different with subclass
        appleList.add(new Apple());
        appleList.add(new RedApple());
        appleHolder.setItem(new RedApple());
    }

    public void addAppleToList(Apple apple) {
        appleList.add(apple);
    }

    public Holder.Apple getTheFirstApple(List<? super Holder.Apple> appleList) {
//        return appleList.get(0); compile error
        return null;
    }

}
