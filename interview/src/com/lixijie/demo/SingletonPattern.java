package com.lixijie.demo;

/**
 * @author lxj
 * @datetime
 */
public class SingletonPattern {

    private static volatile SingletonPattern SingletonPattern = null;

    private SingletonPattern() {
        System.out.println(Thread.currentThread().getName() + "------------------------");
    }



    /*懒汉模式
    * 对方法加锁影响效率*/
 /*   public static synchronized  SingletonPattern getInstance(){
        if (SingletonPattern==null) {
            SingletonPattern = new SingletonPattern();
        }
        return SingletonPattern;
    }*/

    /*饿汉模式
    * 需要单独写一个类*/
   /*public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton (){}
    public static Singleton getInstance() {
    return instance;
    }
}*/

    /*双检锁/双重校验锁*/
   /* public static SingletonPattern getInstance() {
        if (SingletonPattern == null) {
            synchronized (SingletonPattern.class) {
                if (SingletonPattern == null) {
                    SingletonPattern = new SingletonPattern();
                }
            }
        }
        return SingletonPattern;
    }*/

    public static void main(String[] args) {
        /*双检锁/双重校验锁*/
     /*   for (int i = 0; i < 20; i++) {
            new Thread() {
                @Override
                public void run() {
                    SingletonPattern.getInstance();
                }
            }.start();
        }*/

     /*懒汉模式*/
       /* for (int i = 0; i < 20; i++) {
            new Thread() {
                @Override
                public void run() {
                    SingletonPattern.getInstance();
                }
            }.start();
        }*/
       /*饿汉模式*/


    }





}
