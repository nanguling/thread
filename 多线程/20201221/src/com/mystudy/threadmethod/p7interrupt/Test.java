package com.mystudy.threadmethod.p7interrupt;

public class Test {
    public static void main(String[] args) {
        Thread t1 = new SubThread();
        t1.start();//开启一个子线程

        //当前线程是main线程
        for (int i = 0; i < 100; i++) {
            System.out.println("main thread --> "+i);
        }
        //中断子线程
        t1.interrupt();//仅仅是给子线程标记中断，子线程并没有真正的中断
    }
}
