package com.learn.thinking.generic.boundary;

import com.learn.thinking.generic.boundary.variant.Holder;

import java.applet.Applet;

public class RawAndUnbounded {

    private Holder rawHolder = new Holder();
    private Holder<Long> qualifiedHolder = new Holder<>();
    private Holder<?> unboundedHolder = new Holder<>();
    private Holder<? extends Long> upperBoundedHolder = new Holder<>();
    private Holder<? super Long> lowerBoundedHolder = new Holder<>();

    private void rawArgs(Holder holder, Object arg) {
        holder.setItem(arg);//warning, unchecked assignment
        holder.setItem(new StringBuilder());//warning, unchecked assignment
        Object result = holder.getItem();
    }

    private void doInvokeWithRaw() {
        Long aLong = 1L;
        rawArgs(rawHolder, aLong);
        rawArgs(qualifiedHolder, aLong);
        rawArgs(unboundedHolder, aLong);
        rawArgs(upperBoundedHolder, aLong);
    }

    private void unboundedArgs(Holder<?> holder, Object arg) {
//        holder.setItem(arg); error
        Object result = holder.getItem();
    }

    private void doInvokeWithUnbounded() {
        Long aLong = 1L;
        unboundedArgs(rawHolder, aLong);
        unboundedArgs(qualifiedHolder, aLong);
        unboundedArgs(unboundedHolder, aLong);
        unboundedArgs(upperBoundedHolder, aLong);
    }

    private void exactStringArgs(Holder<String> holder, String arg) {
        holder.setItem(arg);
        String result = holder.getItem();
    }

    private <T> T exactArgs(Holder<T> holder) {
        return holder.getItem();
    }

    private void doGetFromExact() {
        Object resultA = exactArgs(rawHolder);//unchecked assignment
        Long resultB = exactArgs(qualifiedHolder);
        Object resultC = exactArgs(unboundedHolder);//no warning
        Long resultD = exactArgs(upperBoundedHolder);
    }

    private <T> T exactArgs(Holder<T> holder, T arg) {
        holder.setItem(arg);
        return holder.getItem();
    }

    private void doGetFromExactWithArgs() {
        Long aLong = 44L;
        Object resultA = exactArgs(rawHolder, aLong);//unchecked assignment
        Long resultB = exactArgs(qualifiedHolder, aLong);
//        Object resultC = exactArgs(unboundedHolder, aLong);
//        Long resultD = exactArgs(upperBoundedHolder, aLong);
    }

    private <T> T upperBoundedArgs(Holder<? extends T> holder, T arg) {
//        holder.setItem(arg); error
        return holder.getItem();
    }

    private void doGetFromUpperBoundedArgs() {
        Long aLong = 34L;
        Object resultA = upperBoundedArgs(rawHolder, aLong);//unchecked assignment
        Long resultB = upperBoundedArgs(qualifiedHolder, aLong);
        Object resultC = upperBoundedArgs(unboundedHolder, aLong);
        Object resultD = upperBoundedArgs(upperBoundedHolder, aLong);
    }

    private <T> void lowerBoundedArgs(Holder<? super T> holder, T arg) {
        holder.setItem(arg);
//        T result = holder.getItem(); error
        Object result = holder.getItem();//OK, but type information has been lost:
    }

    private void doInvokeLowerBounded() {
        Long aLong = 34L;
        lowerBoundedArgs(rawHolder, aLong);//unchecked assignment
        lowerBoundedArgs(qualifiedHolder, aLong);
//        lowerBoundedArgs(unboundedHolder, aLong);
//        lowerBoundedArgs(upperBoundedHolder, aLong);
    }
}
