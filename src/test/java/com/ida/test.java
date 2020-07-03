package com.ida;

public class test {

    public static class MyRunnbale implements Runnable{
        ThreadLocal<String> THREADLOCAL=new ThreadLocal<>();
        @Override
        public void run() {
            THREADLOCAL.set("Math.random()="+Math.random());
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(THREADLOCAL.get().toString());

        }
    }

    public static void main(String[] args){
        MyRunnbale myRunnbale=new MyRunnbale();
        Thread thread=new Thread(myRunnbale);
        Thread thread1=new Thread(myRunnbale);
        thread.start();
        thread1.start();

    }


}
