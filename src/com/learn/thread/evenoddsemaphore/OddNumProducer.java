package com.learn.thread.evenoddsemaphore;

public class OddNumProducer implements Runnable{

    private SharedPrinter sp;
    private int maxNum;

    public OddNumProducer(SharedPrinter sp,int maxNum) {
        this.sp = sp;
        this.maxNum = maxNum;
    }

    @Override
    public void run() {
        for(int i=1;i<=maxNum;i+=2){
            sp.printOddNum(i);
        }
    }
}
