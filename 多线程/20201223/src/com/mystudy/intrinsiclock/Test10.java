package com.mystudy.intrinsiclock;

/**
 * 死锁
 *  在多线程程序中，同步时可能需要使用多个锁，如果我们获得锁的顺序不一致，就可能会导致死锁
 * 如何避免死锁？
 *  当需要获得多个锁时，所有线程获得锁的顺序保持一致即可
 */
public class Test10 {
    public static void main(String[] args) {
        Thread a = new SubThread();
        a.setName("a");
        a.start();

        Thread b = new SubThread();
        b.setName("b");
        b.start();
    }

    static class SubThread extends Thread{
        private static final Object lock1 = new Object();
        private static final Object lock2 = new Object();

        @Override
        public void run() {
            if ("a".equals(Thread.currentThread().getName())) {
                synchronized (lock1) {
                    System.out.println("a线程已经获得了lock1锁，还需要获得lock2锁");
                    synchronized (lock2) {
                        System.out.println("a线程获得了lock2锁");
                    }
                }
            }
            if ("b".equals(Thread.currentThread().getName())) {
                synchronized (lock2) {
                    System.out.println("b线程已经获得了lock2锁，还需要获得lock1锁");
                    synchronized (lock1) {
                        System.out.println("b线程获得了lock1锁");
                    }
                }
            }
        }
    }
}
