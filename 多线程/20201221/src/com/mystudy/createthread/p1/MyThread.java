package com.mystudy.createthread.p1;

/**
 * 1.定义类继承Thread
 */
public class MyThread extends Thread {
    //2.重写Thread父类中的run方法
    //run方法中的代码就是子线程要执行的任务
    @Override
    public void run() {
        System.out.println("这是子线程打印的内容");
    }
}
