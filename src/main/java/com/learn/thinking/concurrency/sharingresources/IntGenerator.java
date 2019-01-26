package com.learn.thinking.concurrency.sharingresources;

public abstract class IntGenerator {

    private volatile boolean isCanceled = false;

    public void cancel(){
        isCanceled = true;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public abstract int next();
}
