package com.lixijie.demo;

import java.util.concurrent.TimeUnit;

/**
 * 资源类
 */
class LockResource implements Runnable{
    private String lockA;
    private String lockB;

    public LockResource(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {

        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"进入"+lockA+"尝试获取"+lockB);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"进入"+lockB+"尝试获取"+lockA);
            }

        }
    }
}

/**
 *死锁例子
 * @author lixijie
 * 查看死锁   jps -l
 * jstack    进程号
 */
public class DeadLockDemo {
    public static void main(String[] args) {

        new Thread(new LockResource("locka","lockb"),"AAAA"){}.start();
        new Thread(new LockResource("lockb","locka"),"BBBB"){}.start();
    }
}
