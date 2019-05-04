package com.learn.thinking.generic.earsure;

public class Manipulator<T extends Flyable> {

    final private T t;

    public Manipulator(T t) {
        this.t = t;
    }

    public void fly() {
        t.fly();
    }

    /*
    * We could perform the erasure like this
    * */

    private static class AnotherManipulator {
        final private Flyable flyable;

        public AnotherManipulator(Flyable flyable) {
            this.flyable = flyable;
        }

        public void fly() {
            this.flyable.fly();
        }

        public Flyable getFlyable() {
            return flyable;
        }
    }

    private static class UsefulManipulator<T extends Flyable> {
        final private T t;

        public UsefulManipulator(T t) {
            this.t = t;
        }

        public void fly() {
            t.fly();
        }

        public T getFlyable() {
            return t;
        }
    }



}
