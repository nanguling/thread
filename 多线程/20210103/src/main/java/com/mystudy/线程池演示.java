package com.mystudy;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class 线程池演示 {

    static class MyRunnable implements Runnable {
        public void run() {
            for (int i = 0; i < 10000000; i++) {
                System.out.println("hello");
            }
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                10,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));
        ExecutorService service = threadPoolExecutor;
        Executor executor = threadPoolExecutor;

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
        service.shutdown();

        /*executor.execute(new MyRunnable());

        for (int i = 0; i < 10000000; i++) {
            System.out.println("world");
        }*/
    }
}
