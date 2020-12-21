package com.mystudy.threadmethod.p2isAlive;

public class SubThread3 extends Thread {
    @Override
    public void run() {
        System.out.println("run方法，isAlive=="+this.isAlive());//运行状态，true
    }
}
