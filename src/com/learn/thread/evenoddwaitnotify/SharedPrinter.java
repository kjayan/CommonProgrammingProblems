package com.learn.thread.evenoddwaitnotify;


public class SharedPrinter {
    private boolean evenFlag = false;

    public void printEvenNum(int num){
        synchronized (this){
            while(!evenFlag){
                try{
                    wait();
                }catch (InterruptedException e){

                }
            }
            System.out.println(num);
            evenFlag = false;
            notify();
        }

    }

    public void printOddNum(int num){
        synchronized (this) {
            while (evenFlag) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
            System.out.println(num);
            evenFlag = true;
            notify();
        }
    }

}
