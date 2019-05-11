package com.learn.thinking.generic.boundary.variant;

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

}
