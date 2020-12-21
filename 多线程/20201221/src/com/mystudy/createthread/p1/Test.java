package com.mystudy.createthread.p1;

public class Test {
    public static void main(String[] args) {
        System.out.println("JVM启动main线程，main线程执行main方法");
        //3.创建子线程对象
        MyThread thread = new MyThread();
        //4.启动线程
        thread.start();
        /*
            调用线程的start方法来启动线程。启动线程的实质就是请求JVM运行相应的线程，这个线程具体在什么时候运行由线程调度器（Scheduler）来决定。
            注意：
                1.start方法调用结束并不意味着子线程开始运行
                2.新开启的线程会执行run方法
                3.如果开启了多个线程，start调用的顺序并不一定就是线程启动的顺序
                4.多线程运行结果与代码顺序或调用顺序无关
         */
        System.out.println("main线程后面其他的代码。。。");
    }
}
