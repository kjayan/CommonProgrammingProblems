package com.learn.thread.pcwaitnotify;

import java.util.ArrayList;
import java.util.List;

public class ProdConsMain {

    public static void main(String[] args) {

        List<Integer> sharedQueue = new ArrayList<>();

        Producer p = new Producer(sharedQueue);
        Consumer c = new Consumer(sharedQueue);

        Thread producer = new Thread(p);
        Thread consumer = new Thread(c);

        producer.start();
        consumer.start();
    }
}
