package com.learn.thinking.concurrency.result;

import com.learn.thinking.concurrency.TaskWithResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestCallable {

    public static void main(String[] args) {
        new TestCallable().useFutureTask();
    }

    private void useCallable(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<>();
        for (int index = 0; index < 10; index ++){
            results.add(executorService.submit(new TaskWithResult(index)));
        }
        for(Future<String> future : results){
            try {
                // get() blocks until completion
                System.out.println(future.get());
            } catch (InterruptedException|ExecutionException exception) {
                exception.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }
    }

    private void useFutureTask(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureTask<String> futureTask = new FutureTask<String>(new TaskWithResult(1));
        executorService.execute(futureTask);
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException|ExecutionException exception) {
            exception.printStackTrace();
        }finally {
            executorService.shutdown();
        }

    }
}
