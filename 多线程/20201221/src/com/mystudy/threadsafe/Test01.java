package com.mystudy.threadsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示线程的原子性问题
 */
public class Test01 {
    public static void main(String[] args) {

        //启动两个线程，不断调用getNum()方法
        MyInt myInt = new MyInt();
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println(Thread.currentThread().getName()+"-->"+myInt.getNum());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    static class MyInt1{
        int num;
        public int getNum() {
            return num++;
            /*
                ++自增操作实现的步骤：
                    读取num的值
                    num自增
                    把自增后的值再赋值给num变量
             */
        }
    }

    //在java中提供了一个线程安全的AtomicInteger类，保证了操作的原子性
    static class MyInt{
        AtomicInteger num = new AtomicInteger();
        public int getNum() {
            return num.getAndIncrement();
        }
    }
}
