package com.learn.thinking.generic.boundary.variant;

import com.learn.thinking.generic.boundary.variant.Holder.Apple;
import com.learn.thinking.generic.boundary.variant.Holder.Fruit;
import com.learn.thinking.generic.boundary.variant.Holder.Orange;

import java.util.ArrayList;
import java.util.List;

public class CovariantGeneric {

    private List<? extends Fruit> fruits = new ArrayList<Apple>();
    private Holder<? extends Fruit> fruitHolder = new Holder<Apple>();


    private void addFruitToList(List<? extends Fruit> fruits) {
//        fruits.add(new Fruit());
//        fruits.add(new Apple());
    }

    private void addFruitToHolder(Holder<? extends Fruit> fruitHolder) {
//        fruitHolder.setItem(new Fruit());
//        fruitHolder.setItem(new Apple());
    }

    private void showCovariantGeneric() {
        Holder<Apple> appleHolder = new Holder<>();
        appleHolder.setItem(new Apple());


//        Holder<Fruit> fruitHolder = appleHolder; compile error
        Holder<? extends Fruit> anotherFruitHolder = appleHolder;
//        anotherFruitHolder.setItem(new Apple()); compile error
    }

    public Orange getOrangeFromHolder(Holder<? extends Fruit> fruitHolder) {
        return (Orange) fruitHolder.getItem();
    }


}
