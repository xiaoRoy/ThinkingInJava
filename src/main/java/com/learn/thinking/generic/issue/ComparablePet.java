package com.learn.thinking.generic.issue;

import javax.annotation.Nonnull;

public class ComparablePet implements Comparable<ComparablePet> {

    @Override
    public int compareTo(@Nonnull ComparablePet another) {
        return 0;
    }

    /*private static class Cat extends ComparablePet implements Comparable<Cat>{
        @Override
        public int compareTo(@Nonnull Cat another) {
            return 0;
        }
    }*/

    private static class Dog implements Comparable<ComparablePet> {
        @Override
        public int compareTo(@Nonnull ComparablePet another) {
            return 0;
        }
    }

    private static class Hamster extends ComparablePet {

        @Override
        public int compareTo(@Nonnull ComparablePet another) {
            return super.compareTo(another);
        }
    }
}
