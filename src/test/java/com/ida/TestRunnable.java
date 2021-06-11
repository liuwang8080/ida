package com.ida;

public class TestRunnable implements Runnable{

    public synchronized void get(){
        System.out.println(Thread.currentThread().getId());
        set();
    }
    public synchronized void set(){
        System.out.println(Thread.currentThread().getId());

    }

    @Override
    public void run() {
        get();
    }

    public static  void main(String[] args){
        TestRunnable testRunnable=new TestRunnable();
        new Thread(testRunnable).start();
        new Thread(testRunnable).start();
        new Thread(testRunnable).start();
    }
}
