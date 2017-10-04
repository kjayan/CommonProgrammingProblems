package com.learn.thread;

public class ThreadUsingRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread using runnable");
        for(int i=0;i<5;i++){
            System.out.println("Thread name: "+Thread.currentThread().getName()+"-"+i);
        }
    }
}
