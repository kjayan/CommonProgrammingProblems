package com.learn.thread.evenoddsemaphore;

import java.util.concurrent.Semaphore;

public class SharedPrinter {

    private Semaphore evenSem =  new Semaphore(0);
    private Semaphore oddSem = new Semaphore(1);

    public void printEvenNum(int num){
        try {
            evenSem.acquire();
        }catch (InterruptedException e){

        }
        System.out.println(num);
        oddSem.release();
    }

    public void printOddNum(int num){
        try{
            oddSem.acquire();
        }catch (InterruptedException e){

        }
        System.out.println(num);
        evenSem.release();
    }

}
