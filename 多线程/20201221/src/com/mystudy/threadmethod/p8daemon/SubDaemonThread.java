package com.mystudy.threadmethod.p8daemon;

public class SubDaemonThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("sub thread...");
        }
    }
}
