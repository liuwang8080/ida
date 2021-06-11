package com.ida.ReentrantLock;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class DataCache{
   private Map<String,String> cacheData=new HashMap<>();
   private ReadWriteLock lock=new ReentrantReadWriteLock();
   private final Lock readLock=lock.readLock();
   private final Lock writeLock=lock.writeLock();

   public long readSize(){
       try{
            readLock.lock();
            mockTimeConmingopt();
            return cacheData.size();
       }finally {
          readLock.unlock();
       }
   }

   public long write(String key,String value){
       try{
           writeLock.lock();
           mockTimeConmingopt();
           cacheData.put(key,value);
           return cacheData.size();
       }finally {
           writeLock.unlock();
       }
   }

   private void mockTimeConmingopt(){
       try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
}

class Reader extends Thread{
    public  DataCache dataCache;

    public Reader(String name,DataCache dataCache){
        super(name);
        this.dataCache=dataCache;
    }
    @Override
    public void run(){
        String name=Thread.currentThread().getName();
        long result=dataCache.readSize();
        System.out.println(name+"");
    }
}

class Write extends Thread{
    public DataCache dataCache;

    public Write(String name,DataCache dataCache){
        super(name);
        this.dataCache=dataCache;
    }

    @Override
    public void run(){
         String name=Thread.currentThread().getName();
         long  result=dataCache.write(name,"data："+name);
         System.out.println(name+" write to current cache!");
    }

}

public class test {

    public static void main(String[] args){
        final DataCache dataCache=new DataCache();
        ArrayList<Thread> worker=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                Write write=new Write("write"+i,dataCache);
                worker.add(write);
            }else{
                Reader reader=new Reader("reader"+i,dataCache);
                worker.add(reader);
            }
            
        }

        for (int i = 0; i < worker.size(); i++) {
            worker.get(i).start();
        }
    }

}
