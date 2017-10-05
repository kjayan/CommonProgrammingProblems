package com.learn.thread.pcfileread;

import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class PCFileReadMain {

    public static void main(String[] args) throws Exception{

        BufferedReader ibr = null;
        BufferedWriter obw = null;

        try {
            String inputFilePath = "src/com/learn/thread/pcfileread/text-file.txt";
            String outputFilePath = "src/com/learn/thread/pcfileread/text-file-op.txt";

            Semaphore sc1 = new Semaphore(0);
            Semaphore sc2 = new Semaphore(0);
            Semaphore sc3 = new Semaphore(0);
            Semaphore sc4 = new Semaphore(0);
            Semaphore sc5 = new Semaphore(0);

            InputStream is = new FileInputStream(inputFilePath);
            InputStreamReader isr = new InputStreamReader(is);
            ibr = new BufferedReader(isr);

            File outputFile = new File(outputFilePath);
            FileWriter fw = new FileWriter(outputFile, true);
            obw = new BufferedWriter(fw);

            obw.write("testing writing");


            FileCopier c1 = new FileCopier(outputFilePath, sc1, sc2, ibr, obw, 1);
            FileCopier c2 = new FileCopier(outputFilePath, sc2, sc3, ibr, obw, 2);
            FileCopier c3 = new FileCopier(outputFilePath, sc3, sc4, ibr, obw, 3);
            FileCopier c4 = new FileCopier(outputFilePath, sc4, sc5, ibr, obw, 4);
            FileCopier c5 = new FileCopier(outputFilePath, sc5, sc1, ibr, obw, 5);

            Thread t1 = new Thread(c1);
            Thread t2 = new Thread(c2);
            Thread t3 = new Thread(c3);
            Thread t4 = new Thread(c4);
            Thread t5 = new Thread(c5);

            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();

            sc1.release(1);
            while(!t1.isAlive() && !t2.isAlive() && !t3.isAlive() && !t4.isAlive() && !t5.isAlive()){
                ibr.close();
                obw.close();
            }
        }finally {


        }
    }
}
