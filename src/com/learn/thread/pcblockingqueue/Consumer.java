package com.learn.thread.pcblockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Integer> sharedQueue;

    public Consumer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while(true){
            try{
                System.out.println("Consumed:"+this.sharedQueue.take());
            }catch (InterruptedException e){

            }

        }
    }
}
