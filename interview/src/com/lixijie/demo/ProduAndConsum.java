package com.lixijie.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 资源类
 */
class MySource {
    /**
     * 表示功能的开关
     */

    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> blockingQueue;

    public MySource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName() + "类型");
    }

    public void producer() {
        String data = null;
        boolean ifsucce = false;
        try {
            while (FLAG) {
                data = atomicInteger + "";
                ifsucce = blockingQueue.offer(data, 10, TimeUnit.SECONDS);
                if (ifsucce) {
                    System.out.println(Thread.currentThread().getName() + "产生成功");
                } else {
                    System.out.println(Thread.currentThread().getName() + "产生失败");
                }
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println(Thread.currentThread().getName() + "停止生产");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consume() {
        String ifsucce = null;
        try {
            while (FLAG) {
                ifsucce = blockingQueue.poll(2, TimeUnit.SECONDS);
                    if(ifsucce==null||ifsucce.equalsIgnoreCase("")){
                        System.out.println(Thread.currentThread().getName() + "消费失败");
                        FLAG=false;
                        return;
                    }else{
                        System.out.println(Thread.currentThread().getName() + "消费成功");

                    }
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println(Thread.currentThread().getName() + "停止消费");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void stop() {
        FLAG = false;
        System.out.println(Thread.currentThread().getName() + "停止");
    }

}

/**
 * 通过阻塞队列模仿生产者与消费者模式
 */
public class ProduAndConsum {
    public static void main(String[] args) {
        BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(10);
        MySource mySource = new MySource(arrayBlockingQueue);

        new Thread("BB") {
            @Override
            public void run() {
                super.run();
                    mySource.consume();
            }
        }.start();



        new Thread("AA") {
            @Override
            public void run() {
                super.run();
                    mySource.producer();
            }
        }.start();





        try {
            TimeUnit.SECONDS.sleep(10);
            mySource.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
