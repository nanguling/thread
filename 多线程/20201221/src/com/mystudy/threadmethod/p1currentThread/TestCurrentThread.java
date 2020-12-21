package com.mystudy.threadmethod.p1currentThread;

public class TestCurrentThread {
    public static void main(String[] args) {
        System.out.println("main方法中打印当前线程："+Thread.currentThread().getName());

        //创建子线程,调用SubThread1()构造方法，在main线程中调用构造方法，所以构造方法中的当前线程对象就是main线程
        Thread thread = new SubThread1();
        thread.start();//启动子线程，子线程会调用run方法，所以run方法中的当前线程就是Thread-0子线程

        thread.run();//main方法中直接调用run方法，没有开启新线程，所以在当前run方法中的当前线程就是main线程
    }
}
