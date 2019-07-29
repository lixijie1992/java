package com.lixijie.demo;


import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 模拟缓存
 */
class MyCache {
    private volatile HashMap<String, Object> map = new HashMap();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 写操作
     */
    public void put(String key, Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始写入");
            Thread.sleep(3000);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入结束");

        } catch (Exception e) {

        } finally {
            lock.writeLock().unlock();
        }


    }

    /**
     * 读操作
     */

    public void get(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始读取");
            Thread.sleep(3000);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取结束"+ map.get(key));

        } catch (Exception e) {

        } finally {
            lock.readLock().unlock();
        }
    }
}

/**
 * 读写锁验证
 *
 * @author lixijie
 * @date 2019-07-10
 */
public class ReadWriteLock {

    public static void main(String[] args) {
        MyCache cache = new MyCache();
        for (int i = 0; i <20 ; i++) {
            final int tmp =i;
            new Thread(String.valueOf(i)){
                @Override
                public void run() {
                    cache.put(tmp+"",tmp);
                }
            }.start();
        }

        for (int i = 0; i <20 ; i++) {
            final int tmp =i;
            new Thread(String.valueOf(i)){
                @Override
                public void run() {
                    cache.get(tmp+"");
                }
            }.start();
        }
    }

}
