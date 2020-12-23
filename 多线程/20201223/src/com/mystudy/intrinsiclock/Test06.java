package com.mystudy.intrinsiclock;

/**
 * synchronized同步静态方法
 *      把整个方法体作为同步代码块
 *      默认的锁对象是当前类的运行时类对象，Test06.class，有人称他为【类锁】
 */
public class Test06 {
    public static void main(String[] args) {
        //创建两个线程分别调用mm方法
        //先创建Test01对象，通过对象调用这个方法
        Test06 obj = new Test06();

        //thread-0调用mm方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.m1();//使用的锁对象就是obj对象
            }
        }).start();

        //thread-1调用mm2方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                Test06.sm2();//使用的锁对象也是obj对象，可以同步
            }
        }).start();
    }

    //定义一个方法，打印100行字符串
    public void m1(){
        synchronized(Test06.class) {//使用当前类的运行时类对象作为锁对象，可以简单理解为把Test06类的字节码文件作为锁对象
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "---->" + i);
            }
        }
    }

    //同步静态方法
    //使用synchronized修饰
    //默认当前类的运行时类Test06.class为锁对象
    public static synchronized void sm2(){
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }
    }
}
