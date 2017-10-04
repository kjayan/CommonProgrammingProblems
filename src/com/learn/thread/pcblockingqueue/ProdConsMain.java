package com.learn.thread.pcblockingqueue;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProdConsMain {

    public static void main(String[] args) {

        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();

        Producer p = new Producer(sharedQueue);
        Consumer c = new Consumer(sharedQueue);

        Thread producer = new Thread(p);
        Thread consumer = new Thread(c);

        producer.start();
        consumer.start();
    }
}
