package com.learn.thinking.generic.boundary;

import com.learn.thinking.generic.boundary.variant.Holder;

public class CaptureConversion {

    private <T> void exactType(Holder<T> holder) {
        T item = holder.getItem();
        System.out.println(item.getClass().getSimpleName());
    }


    private void unboundedType(Holder<?> holder) {
        exactType(holder);
    }

    private void doCaptureConversion() {
        Holder rawHolder = new Holder();
        exactType(rawHolder);//Unchecked assignment
        unboundedType(rawHolder);
        Holder<?> stringHolder = new Holder<>("44");
        unboundedType(stringHolder);
    }

}
