package com.mystudy.threadmethod.p4getid;

public class Test {
    public static void main(String[] args) {
        System.out.println("main name=="+Thread.currentThread().getName()+",id=="+Thread.currentThread().getId());

        //子线程的id
        for (int i = 0; i < 50; i++) {
            SubThread t5 = new SubThread();
            t5.start();
        }
    }
}
