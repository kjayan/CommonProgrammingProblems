package com.learn.thread;

public class ThreadUsingAbstractClass extends Thread{

    @Override
    public void run() {
        System.out.println("Thread using inheritance");
        super.run();
    }
}
