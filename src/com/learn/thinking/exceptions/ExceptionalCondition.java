package com.learn.thinking.exceptions;

public class ExceptionalCondition {

    private int calculateQuotient(int x, int y){
        if(y == 0){
            throw new IllegalArgumentException();
        }
        return x / y;
    }
}
