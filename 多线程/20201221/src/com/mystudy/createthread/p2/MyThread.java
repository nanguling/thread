package com.mystudy.createthread.p2;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println("sub thread:"+i);
            int time = (int) (Math.random()*1000);
            try {
                Thread.sleep(time);//线程睡眠，单位是毫秒，1s==1000ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
