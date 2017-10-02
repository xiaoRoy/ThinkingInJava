package com.learn.thinking.concurrency;

public class LiftOff implements Runnable {

    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount ++;

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public LiftOff() {
    }

    public String status(){
        String threadName = Thread.currentThread().getName();
        return "Thread Name: " + threadName + "\n"
                + "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    @Override
    public void run() {
        while (countDown -- > 0){
            System.out.println(status());
            Thread.yield();
        }
    }
}
