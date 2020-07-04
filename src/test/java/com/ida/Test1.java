package com.ida;

public class Test1 {
    private static Test1 ourInstance = new Test1();

    public static Test1 getInstance() {
        return ourInstance;
    }

    private Test1() {
    }

    public static void main(String[] args) throws InterruptedException {
       Thread  thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 finish" );
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 finish");
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("ALL PARSER FINISH");



    }


}
