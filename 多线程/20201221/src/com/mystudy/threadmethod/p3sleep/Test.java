package com.mystudy.threadmethod.p3sleep;

public class Test {
    public static void main(String[] args) {
        Thread t4 = new SubThread4();
        System.out.println("main_begin=="+System.currentTimeMillis());
        //t4.start();//开启的新线程
        t4.run();//在main线程中调用run方法，没有开启新线程
        System.out.println("main_end=="+System.currentTimeMillis());
    }
}
