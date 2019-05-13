package com.learn.thinking.generic.boundary.variant;


import java.util.ArrayList;
import java.util.List;

import com.learn.thinking.generic.boundary.variant.Holder.Apple;
import com.learn.thinking.generic.boundary.variant.Holder.RedApple;

public class SuperTypeWildcards {

    private List<? super Apple> appleList = new ArrayList<>();

    private Holder<? super Apple> appleHolder = new Holder<>();

    public SuperTypeWildcards() {
        appleList.add(new Apple());
        appleList.add(new RedApple());
        appleHolder.setItem(new RedApple());
    }

    public void addAppleToList(Apple apple) {
        appleList.add(apple);
    }


}
