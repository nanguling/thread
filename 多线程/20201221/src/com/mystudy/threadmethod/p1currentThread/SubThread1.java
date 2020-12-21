package com.mystudy.threadmethod.p1currentThread;

/**
 * 定义一个线程类
 *      分别在构造方法和run方法中打印当前线程
 */
public class SubThread1 extends Thread {
    public SubThread1() {
        System.out.println("构造方法打印当前线程的名称："+Thread.currentThread().getName());
    }
    @Override
    public void run() {
        System.out.println("run方法打印当前线程的名称："+Thread.currentThread().getName());
    }
}
