package com.learn.thinking.concurrency.sharingresources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

    private final int id;
    private IntGenerator intGenerator;

    public EvenChecker(int id, IntGenerator intGenerator) {
        this.id = id;
        this.intGenerator = intGenerator;
    }

    @Override
    public void run() {
        while (!intGenerator.isCanceled()){
            int result = intGenerator.next();
            if(result % 2 != 0){
                System.out.println(result + " not even!");
                intGenerator.cancel();
            }
        }
    }

    public static void test(IntGenerator intGenerator, int taskCount){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int index = 0; index < taskCount; index++) {
            executorService.execute(new EvenChecker(index, intGenerator));
        }
        executorService.shutdown();
    }

    public static void test(IntGenerator intGenerator){
        test(intGenerator, 10);
    }
}
