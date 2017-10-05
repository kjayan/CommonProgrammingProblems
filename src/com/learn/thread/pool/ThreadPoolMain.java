package com.learn.thread.pool;

public class ThreadPoolMain {

    public static void main(String[] args) throws Exception{
        ThreadPool threadPool = new ThreadPool(2);
        Task task = new Task();
        threadPool.execute(task);
        threadPool.execute(task);
        threadPool.stop();
    }
}
