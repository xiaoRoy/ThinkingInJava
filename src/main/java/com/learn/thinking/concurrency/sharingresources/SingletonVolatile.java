package com.learn.thinking.concurrency.sharingresources;

public class SingletonVolatile {

    private static volatile SingletonVolatile sInstance;

    private SingletonVolatile(){

    }

    public SingletonVolatile getsInstance(){
        if(sInstance == null){
            synchronized (SingletonVolatile.class){
                if(sInstance == null){
                    /*
                    * assign the memory
                    * make the instance of the object
                    * connect the reference and the memory
                    * these 3 steps could be any order
                    * */
                    sInstance = new SingletonVolatile();
                }
            }
        }
        return sInstance;
    }
}
