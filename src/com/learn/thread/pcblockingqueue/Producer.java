package com.learn.thread.pcblockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Integer> sharedQueue;
    private int maxSize = 2;

    public Producer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try{
                System.out.println("Produced:"+i);
                this.sharedQueue.put(i);
            }catch(InterruptedException e){

            }
        }
    }
}
