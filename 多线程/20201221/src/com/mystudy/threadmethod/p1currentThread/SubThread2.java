package com.mystudy.threadmethod.p1currentThread;

public class SubThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("run方法中，Thread.currentThread().getName()："+Thread.currentThread().getName());
        System.out.println("run方法中，this.getName()："+this.getName());

    }

    public SubThread2() {
        System.out.println("构造方法中，Thread.currentThread().getName()："+Thread.currentThread().getName());
        System.out.println("构造方法中，this.getName()："+this.getName());

    }
}
