package com.lixijie.demo;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch  测试
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
            CountDownLatch countDownLatch = new CountDownLatch(5);
            for (int i = 1; i <6 ; i++) {
                new Thread(CountDownLatchEnum.findVaule(i).getValue()){
                    @Override
                    public void run() {
                        super.run();
                        System.out.println(Thread.currentThread().getName()+"执行了");
                        countDownLatch.countDown();

                    }
                }.start();
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"执行了");
        }
}
