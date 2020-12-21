package com.mystudy.threadmethod.p6priority;

public class Test {
    public static void main(String[] args) {
        Thread ta = new ThreadA();
        ta.setPriority(1);
        ta.start();
        Thread tb = new ThreadB();
        tb.setPriority(10);
        tb.start();
    }
}
