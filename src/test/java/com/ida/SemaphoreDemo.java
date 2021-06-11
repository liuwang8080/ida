package com.ida;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

   static class TaskThread extends Thread{
        Semaphore semaphore;
        public TaskThread(Semaphore semaphore){
             this.semaphore=semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                Thread.sleep(3000L);
                System.out.println(getName()+"acquire");
                semaphore.release();
                System.out.println(getName()+"release");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        int data=5;
        Semaphore semaphore=new Semaphore(2);
        for (int i = 0; i <data ; i++) {
            new TaskThread(semaphore).start();
        }

    }
}
