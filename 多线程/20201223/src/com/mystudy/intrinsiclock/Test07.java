package com.mystudy.intrinsiclock;

/**
 * 同步方法与同步代码块如何选择
 *
 * 同步方法，锁的粒度粗，执行效率低
 * 同步代码块，锁的粒度细，执行效率高
 */
public class Test07 {
    public static void main(String[] args) {
        Test07 obj = new Test07();

        //thread-0
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.doLongTimeTask();
            }
        }).start();

        //thread-1
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.doLongTimeTask();
            }
        }).start();
    }

    //同步代码块。锁的粒度细，执行效率高
    public void doLongTimeTask2() {
        System.out.println("task begin");
        try {
            Thread.sleep(2000);//模拟该任务需要准备2秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            System.out.println("开始同步");
            for (int i = 1;i <= 100;i++) {
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
        System.out.println("task end");
    }

    //同步方法，锁的粒度粗，执行效率低
    public synchronized void doLongTimeTask() {
        System.out.println("task begin");
        try {
            Thread.sleep(2000);//模拟该任务需要准备2秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            System.out.println("开始同步");
            for (int i = 1;i <= 100;i++) {
                System.out.println(Thread.currentThread().getName()+"-->"+i);
            }
        }
        System.out.println("task end");
    }
}
