package com.mystudy.threadmethod.p6priority;

public class ThreadA extends Thread {
    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        int sum = 0;
        for (long i = 0; i < 10000000000L; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("A耗时："+(end-begin));
    }
}
