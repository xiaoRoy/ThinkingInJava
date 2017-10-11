package com.learn.thinking.concurrency.misc.uimock;

import java.io.IOException;

public class ResponsiveUI extends Thread{

    private static volatile double number = 1;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (true){
            number = number + (Math.PI + Math.E) / number;
        }
    }

    public static void main(String[] args) throws IOException {
        new ResponsiveUI();
        System.in.read();
        System.out.println(number);
    }
}
