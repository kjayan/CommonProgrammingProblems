package com.learn.thread.pcfileread;

import java.io.File;
import java.util.Queue;

public class Consumer implements Runnable{

    private Queue<String> sharedQueue;
    private String filePath;

    public Consumer(Queue<String> sharedQueue, String filePath) {
        this.sharedQueue = sharedQueue;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        File file = new File(filePath);

    }
}
