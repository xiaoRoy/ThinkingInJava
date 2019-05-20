package com.learn.thinking.generic.boundary;

import com.learn.thinking.generic.boundary.variant.Holder;

import java.applet.Applet;

public class RawAndUnbounded {

    private void rawArgs(Holder holder, Object arg) {
        holder.setItem(arg);//warning, unchecked assignment
        holder.setItem(new StringBuilder());//warning, unchecked assignment
        Object result = holder.getItem();
    }

    private void unboundedArgs(Holder<?> holder, Object arg) {
//        holder.setItem(arg); error
        Object result = holder.getItem();
    }

    private void exactStringArgs(Holder<String> holder, String arg) {
        holder.setItem(arg);
        String result = holder.getItem();
    }

    private <T> void exactArgs(Holder<T> holder, T arg) {
        holder.setItem(arg);
        T result = holder.getItem();
    }

    private <T> void upperBoundedArgs(Holder<? extends T> holder, T arg) {
//        holder.setItem(arg); error
        T result = holder.getItem();
    }

    private <T> void lowerBoundedArgs(Holder<? super T> holder, T arg) {
        holder.setItem(arg);
//        T result = holder.getItem(); error
        Object result = holder.getItem();//OK, but type information has been lost:
    }


}
