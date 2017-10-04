package com.learn.thread.evenoddsemaphore;

public class EvenNumProducer implements Runnable{

    private SharedPrinter sp;
    private int maxNum;

    public EvenNumProducer(SharedPrinter sp,int maxNum) {
        this.sp = sp;
        this.maxNum = maxNum;
    }

    @Override
    public void run() {
        for(int i=2;i<=maxNum;i+=2){
            sp.printEvenNum(i);
        }
    }
}
