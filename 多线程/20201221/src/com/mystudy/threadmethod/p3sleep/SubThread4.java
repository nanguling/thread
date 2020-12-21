package com.mystudy.threadmethod.p3sleep;

/**
 * 子线程休眠
 */
public class SubThread4 extends Thread {
    @Override
    public void run() {
        System.out.println("run,threadname="+Thread.currentThread().getName()+",begin=="+System.currentTimeMillis());
        try {
            Thread.sleep(2000);//当前线程睡眠2000ms
        } catch (InterruptedException e) {
            //在子线程的run方法中，如果有受查异常需要处理，只能选择捕获处理，不能抛出处理。
            e.printStackTrace();
        }
        System.out.println("run,threadname="+Thread.currentThread().getName()+",end=="+System.currentTimeMillis());
    }
}
