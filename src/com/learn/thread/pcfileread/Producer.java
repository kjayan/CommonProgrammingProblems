package com.learn.thread.pcfileread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;

public class Producer implements Runnable{

    private Queue<String> sharedQueue;
    private String filePath;

    public Producer(Queue<String> sharedQueue,String filePath) {
        this.sharedQueue = sharedQueue;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        File file = new File(filePath);
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                readNextWord(sc);
            }
        }catch (FileNotFoundException e){
            System.err.println("File not found");
        }catch(InterruptedException e){
            System.err.println("Interrupted Exception");
        }
    }

    private void readNextWord(Scanner sc) throws InterruptedException{
        synchronized (sharedQueue){
            if(sharedQueue.size() > 9){
                System.out.println("Queue is full. Waiting for consumer");
                sharedQueue.wait();
            }
            System.out.println("Read next word");
            this.sharedQueue.add(sc.next());
            sharedQueue.notifyAll();
        }
    }
}
