package com.mystudy.intrinsiclock;

/**
 * synchronized同步代码块
 * 使用常量对象作为锁对象，在不同方法中的同步代码块也可以同步
 */
public class Test04 {
    public static void main(String[] args) {
        //创建两个线程分别调用mm方法
        //先创建Test01对象，通过对象调用这个方法
        Test04 obj = new Test04();
        Test04 obj2 = new Test04();

        //thread-0
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();//使用的锁对象就是OBJ常量对象
            }
        }).start();

        //thread-1
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj2.mm();//使用的锁对象也是OBJ常量对象
            }
        }).start();

        //thread-2
        new Thread(new Runnable() {
            @Override
            public void run() {
                sm();//使用的锁对象也是OBJ常量对象
            }
        }).start();
    }

    public static final Object OBJ = new Object();//定义一个常量
    //定义一个方法，打印100行字符串
    public void mm(){
        synchronized(OBJ) {//使用常量对象作为锁对象
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "---->" + i);
            }
        }
    }


    public static void sm(){
        synchronized(OBJ) {//使用常量对象作为锁对象
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "---->" + i);
            }
        }
    }
}
