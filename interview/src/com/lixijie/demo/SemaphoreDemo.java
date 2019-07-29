package com.lixijie.demo;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);
        for (int i = 0; i < 14; i++) {
            new Thread(String.valueOf(i)){
                @Override
                public void run() {
                    super.run();
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+"获取位置");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                        System.out.println(Thread.currentThread().getName()+"离开位置");
                    }

                }
            }.start();

        }
    }
}
