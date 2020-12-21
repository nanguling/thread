package com.mystudy.createthread.p2;

/**
 * 线程运行结果的随机性
 */
public class Test {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();//开启了子线程

        //当前是main线程
        for (int i = 0; i <10 ; i++) {
            System.out.println("main thread:"+i);
            int time = (int) (Math.random()*1000);
            try {
                Thread.sleep(time);//线程睡眠，单位是毫秒，1s==1000ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
