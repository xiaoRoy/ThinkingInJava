package com.learn.thinking.concurrency.misc.uimock;

import java.io.IOException;

public class UnResponsiveUI {
    private volatile double number = 1;

    public UnResponsiveUI() throws IOException {
        while (number > 0) {
            number = number + (Math.PI + Math.E) / number;
            System.in.read();

        }
    }
}
