package com.learn.thinking.concurrency.sharingresources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestVolatile {


    //can't stop
//    private  boolean isStop;
    private volatile boolean isStop;

    public static void main(String[] args) {
        TestVolatile testVolatile = new TestVolatile();
        ExecutorService executorService =
                Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (;;){
                    if(testVolatile.isStop()){
                        break;
                    }
                }
                System.out.println("exit");
            }
        });
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int index = 0; index < Integer.MAX_VALUE; index++) {
                    double number = Math.PI * Math.E / (1 / Math.E);
                }
                System.out.println("end of calculation");
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                System.out.println("end of sleep");
                testVolatile.setStop(true);
            }
        });
        executorService.shutdown();
    }

    public boolean isStop() {
        return isStop;
    }

    public void setStop(boolean stop) {
        isStop = stop;
    }

    private static class FlagTask implements Runnable{

        private boolean flag;

        public FlagTask(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            for (int index = 0; index < Integer.MAX_VALUE; index++) {
                double number = Math.PI * Math.E / (1 / Math.E);
            }
            System.out.println("end of calculation");
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            System.out.println("end of sleep");
            flag = true;
        }
    }

    private static class InfiniteRunTask implements Runnable{

        private boolean flag;

        public InfiniteRunTask(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            for (;;){
                if(flag){
                    break;
                }
            }
            System.out.println("exit");
        }
    }
}
