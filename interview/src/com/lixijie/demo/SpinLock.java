package com.lixijie.demo;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 手写一个自旋锁
 */
public class SpinLock {

    //原子引用，内存默认为null
    private AtomicReference<Thread> atomicReference = new AtomicReference<Thread>();

    public void MyLock() {
        Thread thread = Thread.currentThread();
        System.out.println("线程" + thread.getName() + "进入锁");
        /*
        默认无锁为null，加锁为将当前线程thread存入内存，只有当解锁后才能跳出循环，否则一直while循环判断
        atomicReference.compareAndSet(null,thread)
         */
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void MyUnLock() {
        Thread thread = Thread.currentThread();
        System.out.println("线程" + thread.getName() + "退出锁");
        //thread线程相同，则变成无锁，即内存存为null
        atomicReference.compareAndSet(thread, null);
    }


    public static void main(String[] args) {
        SpinLock app = new SpinLock();
        new Thread("AA") {
            @Override
            public void run() {
                app.MyLock();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                app.MyUnLock();
            }
        }.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread("BB") {
            @Override
            public void run() {
                app.MyLock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                app.MyUnLock();
            }
        }.start();

    }


}
