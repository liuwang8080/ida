package com.ida;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    static CountDownLatch downLatch=new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
              System.out.println("1");
              downLatch.countDown();
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2");
              downLatch.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("进入线程");
                try {
                    downLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("结束线程");
            }
        }).start();

        System.out.println("3");
        downLatch.countDown();

    }
}
