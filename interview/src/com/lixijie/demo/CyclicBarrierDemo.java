package com.lixijie.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"人员到齐，开始执行");
            }
        });

        for (int i = 0; i <7 ; i++) {
            new Thread(String.valueOf(i)){
                @Override
                public void run() {
                    super.run();
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+"报道");
                        cyclicBarrier.await();

                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName()+"离场");
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }



    }

}
