package com.mystudy.threadmethod.p5yield;

public class SubThread6 extends Thread {
    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += i;
            Thread.yield();//线程让步，放弃cup的执行权
        }
        long end = System.currentTimeMillis();

        System.out.println("run方法耗时："+(end-begin));
    }
}
