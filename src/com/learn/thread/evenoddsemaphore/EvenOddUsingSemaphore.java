package com.learn.thread.evenoddsemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenOddUsingSemaphore {

    public static void main(String[] args) {
        SharedPrinter sp = new SharedPrinter();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new EvenNumProducer(sp, 10));
        executor.execute(new OddNumProducer(sp, 10));
        executor.shutdown();
    }
}
