package com.lixijie.demo;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 */
class DoThing {

    int num = 1;
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition con1 = reentrantLock.newCondition();
    Condition con2 = reentrantLock.newCondition();
    Condition con3 = reentrantLock.newCondition();


    public void doneThing5() {
        reentrantLock.lock();
        try {
            while (num != 1) {
                con1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
            num=2;
            con2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            reentrantLock.unlock();
        }

    }


    public void doneThing10() {
        reentrantLock.lock();
        try {
            while (num != 2) {
                con2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
            num=3;
            con3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            reentrantLock.unlock();
        }
    }


    public void doneThing15() {
        reentrantLock.lock();
        try {
            while (num != 3) {
                con3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
            num=1;
            con1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            reentrantLock.unlock();
        }
    }

}

/**
 * AA线程操作5次，BB线程操作10次，CC线程操作15次
 * 重复5遍
 */
public class LockConditionDemo {
    public static void main(String[] args) {
        DoThing doThing = new DoThing();
        for (int i = 0; i <3 ; i++) {
            new Thread("AA"){
                @Override
                public void run() {
                    super.run();
                    doThing.doneThing5();
                }
            }.start();

            new Thread("BB"){
                @Override
                public void run() {
                    super.run();
                    doThing.doneThing10();
                }
            }.start();

            new Thread("CC"){
                @Override
                public void run() {
                    super.run();
                    doThing.doneThing15();
                }
            }.start();
        }
    }

}
