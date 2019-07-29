package com.lixijie.demo;
import java.util.concurrent.*;

class ResDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("名称" + Thread.currentThread().getName());
    }
}

/**
 * 线程池的例子
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        /*固定个数的线程 */
        //ExecutorService executorService = Executors.newFixedThreadPool(8);
        /*只有一个线程*/
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        /*动态线程*/
        //ExecutorService executorService = Executors.newCachedThreadPool();
        /*手写线程池,工作中使用这个 ★★★*/
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessors);
        ExecutorService executorService;
        executorService = new ThreadPoolExecutor(
                3,
                9,
                2,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 0; i < 50; i++) {
            executorService.submit(new ResDemo());
        }
    }


}
