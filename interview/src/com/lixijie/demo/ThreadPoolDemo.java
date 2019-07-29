package com.lixijie.demo;
import java.util.concurrent.*;

class ResDemo implements Runnable {
    @Override
    public void run() {
        Object oo =null;
        System.out.println("名称" + Thread.currentThread().getName());
        System.out.println(oo.toString());
    }
}

/**
 * 线程池的例子
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*固定个数的线程 */
        //ExecutorService executorService = Executors.newFixedThreadPool(8);
        /*只有一个线程*/
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        /*动态线程*/
        //ExecutorService executorService = Executors.newCachedThreadPool();
        /*定时及周期执行的线程池*/
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(6);
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

        for (int i = 0; i <2; i++) {
            Future futureTask = executorService.submit(new ResDemo());
            try {
                System.out.println( futureTask.get()+"========================");
            }catch (Exception e){
                System.out.println(e.toString()+"-------------------------");
            }

        }
    }


}
