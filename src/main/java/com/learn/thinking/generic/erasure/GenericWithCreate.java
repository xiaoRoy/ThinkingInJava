package com.learn.thinking.generic.erasure;

public abstract class GenericWithCreate<T> {
    private final T element;

    public GenericWithCreate() {
        element = create();
    }

    abstract T create();

    private static class Phone{}

    private static class PhoneCreator extends GenericWithCreate<Phone>{
        @Override
        Phone create() {
            return new Phone();
        }
    }
}
