package com.learn.thinking.generic.boundary.variant;

import com.learn.thinking.generic.boundary.variant.Holder.Apple;
import com.learn.thinking.generic.boundary.variant.Holder.Fruit;

import java.util.ArrayList;
import java.util.List;

public class NonCovariantGeneric {

    /*
    *
    * If the Java compiler does not stop us from doing this, the run-time type system cannot stop us either,
    * because there is no way to determine that this list was supposed to be a list of integers only at run time.
    * The Java run-time would let us put whatever we want into this list.
    * The Java generic without wildcards is invariant.
    * */
    //Compile Error: incompatible types
    //List<Fruit> fruits = new ArrayList<Apple>();
    //Holder<Fruit> fruitHolder = new Holder<Apple>();


    List<? extends Fruit> fruits = new ArrayList<Apple>();
    Holder<? extends Fruit> fruitHolder = new Holder<Apple>();


    private void addFruitToList(List<? extends Fruit> fruits) {
//        fruits.add(new Fruit());
//        fruits.add(new Apple());
    }

    private void addFruitToHolder(Holder<? extends Fruit> fruitHolder) {
//        fruitHolder.setItem(new Fruit());
//        fruitHolder.setItem(new Apple());
    }
}
