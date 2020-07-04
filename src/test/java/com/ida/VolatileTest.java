package com.ida;

import java.util.concurrent.TimeUnit;

public class VolatileTest implements Runnable {

    private static volatile boolean flag=true;

    @Override
    public void run() {
        while (flag){
            System.out.println("正在运行================");
        }
        System.out.println("结束运行==================");

    }

    public void stop(){
        flag=false;
        System.out.println("stop") ;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest=new VolatileTest();
        Thread thread=new Thread(volatileTest,"thread A");
        thread.start();
        System.out.println("main 线程正在运行") ;
        TimeUnit.MILLISECONDS.sleep(100);
        volatileTest.stop();


    }
}
