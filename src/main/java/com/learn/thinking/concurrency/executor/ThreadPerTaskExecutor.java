package com.learn.thinking.concurrency.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadPerTaskExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
