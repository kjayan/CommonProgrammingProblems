package com.learn.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

    private BlockingQueue<Runnable> taskQueue = null;
    private List<PoolThread> threadList = new ArrayList<>();
    private boolean isStopped = false;

    public ThreadPool(int numThreads){
        this.taskQueue = new LinkedBlockingQueue(numThreads);
        for(int i=0;i<numThreads;i++){
            PoolThread newPoolThread = new PoolThread(taskQueue,this);
            newPoolThread.setName("Thread-"+i);
            threadList.add(newPoolThread);
        }

        for(PoolThread thread: threadList){
            thread.start();
        }
    }

    public synchronized void  execute(Runnable task) throws Exception{
        if(this.isStopped) {
            throw new IllegalStateException("ThreadPool is stopped");
        }
        System.out.println("New task added to pool");
        this.taskQueue.add(task);
    }

    public boolean isThreadPoolStopped(){
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        System.out.println("Thread pool is going to stop");
    }
}
