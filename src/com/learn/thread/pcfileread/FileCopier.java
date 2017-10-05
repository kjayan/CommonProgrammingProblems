package com.learn.thread.pcfileread;

import java.io.*;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class FileCopier implements Runnable{

    private String filePath;
    private Semaphore ownSema;
    private Semaphore nextSema;
    private BufferedReader ibr;
    private BufferedWriter obw;
    private int threadNum;

    public FileCopier(String filePath, Semaphore ownSema, Semaphore nextSema, BufferedReader ibf, BufferedWriter obw,int threadNum) throws  Exception{
        this.filePath = filePath;
        this.ownSema = ownSema;
        this.nextSema = nextSema;
        this.ibr = ibf;
        this.obw = obw;
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        try{
            System.out.println("Trying to acquire sema using thread:: "+ threadNum);
            this.ownSema.acquire();
            copyWord();
            System.out.println("Releasing next sema::"+ threadNum);
            this.nextSema.release(1);
        }catch (InterruptedException e){

        }catch(IOException e){
            System.err.println(e.fillInStackTrace());
        }
    }

    private void copyWord() throws IOException{
        int value = 0;
        String word = "";
        while((value = ibr.read()) != -1){
            char c = (char)value;
            if(c == ' ' || c == '\n' || c == '\t'){
               break;
            }
            word += c;
        }
        System.out.println("Read the word::"+word+" from thread::"+threadNum);
        obw.write(word);
    }
}
