package com.lixijie.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class BLockingQueueDemo {
     public  static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(4);
    BlockingQueue<String> synchronousQueue =  new SynchronousQueue<String>();
    public static void main(String[] args) {
        try {
            blockingQueue.offer("aaa",10, TimeUnit.SECONDS);
            blockingQueue.offer("sss",10, TimeUnit.SECONDS);
            blockingQueue.offer("ddd",10, TimeUnit.SECONDS);
            blockingQueue.offer("fff",10, TimeUnit.SECONDS);
            blockingQueue.offer("ggg",10, TimeUnit.SECONDS);
            System.out.println("-------------------------------------");
            blockingQueue.poll(10,TimeUnit.SECONDS);
            blockingQueue.poll(10,TimeUnit.SECONDS);
            blockingQueue.poll(10,TimeUnit.SECONDS);
            blockingQueue.poll(10,TimeUnit.SECONDS);
            blockingQueue.poll(10,TimeUnit.SECONDS);
            System.out.println("++++++++++++++++++++++++++++++++++++++");
TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
