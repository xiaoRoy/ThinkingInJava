package com.learn.thinking.concurrency;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
      /*  if(id == 3){
            Thread.sleep(5000);
        }*/
        String threadName = Thread.currentThread().getName();
        return "threadName:" + threadName +". Result of TaskWithResult " + id;
    }

}
