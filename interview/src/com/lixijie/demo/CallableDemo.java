package com.lixijie.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 */
class CallableThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("进入callable"+Thread.currentThread().getName());
        return "TRUE";
    }
}

public class CallableDemo {

    public static void main(String[] args) {
        FutureTask<String> stringFutureTask = new FutureTask<>(new CallableThread());
        Thread AA = new Thread(stringFutureTask);
        AA.start();
      while (!stringFutureTask.isDone()){}
        try {
            System.out.println(stringFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
