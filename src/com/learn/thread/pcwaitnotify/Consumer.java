package com.learn.thread.pcwaitnotify;

import java.util.List;

public class Consumer implements Runnable{

    private List<Integer> sharedQueue;

    public Consumer(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while(true){
            try{
                consume();
            }catch (InterruptedException e){

            }

        }
    }

    private void consume() throws InterruptedException{
        synchronized (this.sharedQueue){
            while(this.sharedQueue.size() == 0){
                this.sharedQueue.wait();
            }
            System.out.println("Consumed:"+this.sharedQueue.remove(0));
            this.sharedQueue.notifyAll();
        }
    }
}
