package com.learn.thread.pool;

import java.util.concurrent.BlockingQueue;

public class PoolThread extends Thread{

    private BlockingQueue<Runnable> taskQueue = null;
    private ThreadPool threadPool = null;

    public PoolThread(BlockingQueue taskQueue,ThreadPool threadPool) {
        this.taskQueue = taskQueue;
        this.threadPool = threadPool;
    }

    @Override
    public void run() {
        try{
            while(true){
                System.out.println(Thread.currentThread().getName() +" is READY to execute task.");
                Runnable runnable = taskQueue.take();
                System.out.println(Thread.currentThread().getName() +" has taken task.");
                runnable.run();
                System.out.println(Thread.currentThread().getName() +" has EXECUTED task.");

                if(this.threadPool.isThreadPoolStopped() &&  this.taskQueue.size()==0) {
                    this.interrupt();
                    Thread.sleep(1);
                }
            }
        }catch(Exception e){
            System.out.println(Thread.currentThread().getName()+" has been STOPPED.");
        }
    }
}
