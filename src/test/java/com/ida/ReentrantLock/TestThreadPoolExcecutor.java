package com.ida.ReentrantLock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolExcecutor {
    private final static ThreadPoolExecutor THREAD_POOL_EXECUTOR=
            new ThreadPoolExecutor(8,8,0L, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>());


    public static void main(String[] args){
        List<String> imageList=new ArrayList<String>();
        for (int i = 0; i <3 ; i++) {
            imageList.add("imag"+i);
        }
        long start=System.currentTimeMillis();

    }



}
