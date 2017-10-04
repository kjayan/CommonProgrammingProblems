package com.learn.thread;

public class ThreadMain {

    public static void main(String[] args) throws Exception{
        ThreadUsingRunnable runnable = new ThreadUsingRunnable();
        ThreadUsingCallable callable = new ThreadUsingCallable();
        ThreadUsingAbstractClass abstractClass = new ThreadUsingAbstractClass();

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        callable.call();
        abstractClass.start();

    }
}
