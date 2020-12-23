package com.mystudy.intrinsiclock;

/**
 * synchronized同步实例方法
 *      把整个方法体作为同步代码块
 *      默认的锁对象是this对象
 * this锁对象
 *
 */
public class Test05 {
    public static void main(String[] args) {
        //创建两个线程分别调用mm方法
        //先创建Test01对象，通过对象调用这个方法
        Test05 obj = new Test05();

        //thread-0调用mm方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();//使用的锁对象就是obj对象
            }
        }).start();

        //thread-1调用mm2方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm2();//使用的锁对象也是obj对象，可以同步
            }
        }).start();
    }

    //定义一个方法，打印100行字符串
    public void mm(){
        synchronized(this) {//经常使用this当前对象作为锁对象
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "---->" + i);
            }
        }
    }

    //同步实例方法
    //使用synchronized修饰
    //默认this作为锁对象
    public synchronized void mm2(){
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }
    }
}
