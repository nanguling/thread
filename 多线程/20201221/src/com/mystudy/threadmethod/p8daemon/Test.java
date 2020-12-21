package com.mystudy.threadmethod.p8daemon;

/**
 * 设置线程为守护线程
 */
public class Test {
    public static void main(String[] args) {
        Thread thread = new SubDaemonThread();
        //设置线程为守护线程
        thread.setDaemon(true);//设置守护线程的代码应该在线程启动之前
        thread.start();

        //当前线程为main线程
        for (int i = 0; i < 10; i++) {
            System.out.println("main=="+i);
        }

        //当main线程结束，thread线程也会被销毁
    }
}
