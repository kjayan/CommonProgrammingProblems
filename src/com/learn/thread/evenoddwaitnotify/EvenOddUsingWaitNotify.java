package com.learn.thread.evenoddwaitnotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenOddUsingWaitNotify {

    public static void main(String[] args) {
        SharedPrinter sp = new SharedPrinter();
        Thread t1 = new Thread(new EvenNumProducer(sp, 10));
        Thread t2 = new Thread(new OddNumProducer(sp, 10));
        t1.start();
        t2.start();
    }
}
