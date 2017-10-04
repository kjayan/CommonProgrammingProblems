package com.learn.thread.pcfileread;

import java.io.File;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class PCFileReadMain {

    public static void main(String[] args) throws Exception{
        Queue<String> queue = new LinkedBlockingQueue<>();
        String inputFilePath = "src/com/learn/thread/pcfileread/text-file.txt";
        String outputFilePath = "";

        Producer p = new Producer(queue,inputFilePath);

        Consumer c1 = new Consumer(queue,outputFilePath);
        Consumer c2 = new Consumer(queue,outputFilePath);
        Consumer c3 = new Consumer(queue,outputFilePath);
        Consumer c4 = new Consumer(queue,outputFilePath);
        Consumer c5 = new Consumer(queue,outputFilePath);

        File file = new File(inputFilePath);
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            System.out.println("Next word:"+sc.next());
        }
    }
}
