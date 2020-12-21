package com.mystudy.threadmethod.p4getid;

public class SubThread extends Thread {
    @Override
    public void run() {
        System.out.println("thread name=="+Thread.currentThread().getName()+",id=="+this.getId());
    }
}
