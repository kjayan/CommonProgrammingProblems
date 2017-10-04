package com.learn.thread.pcwaitnotify;

import java.util.List;

public class Producer implements Runnable {

    private List<Integer> sharedQueue;
    private int maxSize = 2;

    public Producer(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try{
                produce(i);
            }catch(InterruptedException e){

            }
        }
    }

    private void produce(int i) throws InterruptedException{
        synchronized (sharedQueue){
            while(sharedQueue.size() == maxSize){
                System.out.println("Queue is full. Waiting for consumer");
                sharedQueue.wait();
            }
            System.out.println("Produced: "+i);
            this.sharedQueue.add(i);
            sharedQueue.notifyAll();
        }
    }
}
