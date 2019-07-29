package com.lixijie.demo;

/**
 *
 */
public class SingletonPattern {

    private static volatile SingletonPattern SingletonPattern = null;

    private SingletonPattern() {
        System.out.println(Thread.currentThread().getName() + "------------------------");
    }

    public static SingletonPattern getInstance() {
        if (SingletonPattern == null) {
            synchronized (SingletonPattern.class) {
                if (SingletonPattern == null) {
                    SingletonPattern = new SingletonPattern();
                }
            }
        }
        return SingletonPattern;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread() {
                @Override
                public void run() {
                    SingletonPattern.getInstance();
                }
            }.start();
        }
    }

}
