package com.learn.thread;

import java.util.concurrent.Callable;

public class ThreadUsingCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println("Thread using callable");
        return null;
    }
}
