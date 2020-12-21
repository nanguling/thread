package com.mystudy.threadsafe;

import java.util.Random;

/**
 * 测试线程的可见性
 */
public class Test02 {
    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(1000);
        //主线程1秒后取消子线程
        task.cancel();
        /*
            可能会出现以下情况：
                在main线程中调用了task.cancel();方法，把task对象的toCancel变量修改为true
                可能存在子线程看不到main线程对toCancel做的修改，在子线程中toCancel变量一直为false
            导致子线程看不到main线程对toCancel变量更新的原因：
                1.JIT即时编译器可能会对run方法中while循环进行优化为：
                    if(!toCancel) {
                        while (true) {
                           if (doSome()) {
                           }
                        }
                    }
                2.可能与计算机存储系统有关，假设分别有两个CPU内核运行main线程与子线程，运行子线程的cpu无法立即读取运行main线程cpu中的数据
         */
    }

    static class MyTask implements Runnable {
        private boolean toCancel = false;

        @Override
        public void run() {
            while (!toCancel) {
                if (doSome()) {
                }
            }
            if (toCancel) {
                System.out.println("任务被取消");
            }else {
                System.out.println("任务正常结束");
            }
        }

        private boolean doSome() {
            System.out.println("执行某个任务。。。");
            try {
                Thread.sleep(new Random().nextInt(1000));//模拟执行任务的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }

        public void cancel(){
            toCancel = true;
            System.out.println("收到取消线程的消息");
        }
    }
}
