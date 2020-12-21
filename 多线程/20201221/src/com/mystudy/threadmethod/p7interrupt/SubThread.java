package com.mystudy.threadmethod.p7interrupt;

public class SubThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("sub thread --> "+i);
        }
    }
}
