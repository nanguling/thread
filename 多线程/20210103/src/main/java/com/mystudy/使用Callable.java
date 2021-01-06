package com.mystudy;
import java.util.concurrent.*;
import java.util.concurrent.ArrayBlockingQueue;

public class 使用Callable {
    static class MyCallable implements Callable<Integer> {

        private Integer a;
        private Integer b;
        MyCallable(Integer a,Integer b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public Integer call() throws Exception {
            Thread.sleep(10000);
            return a + b;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                10,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));
        ExecutorService executorService = threadPoolExecutor;
        Executor executor = executorService;

        Future<Integer> future = executorService.submit(new MyCallable(20, 30));

        System.out.println("hello");
        Integer res = future.get();
        System.out.println("world");
        System.out.println(res);

    }
}
