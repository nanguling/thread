package com.mystudy.intrinsiclock;

/**
 * synchronized同步代码块
 * 如果线程的锁不同，不能实现同步
 * 想要同步必须使用同一个锁对象
 */
public class Test02 {
    public static void main(String[] args) {
        //创建两个线程分别调用mm方法
        //先创建Test01对象，通过对象调用这个方法
        Test02 obj = new Test02();
        Test02 obj2 = new Test02();

        //thread-0
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();//使用的锁对象就是obj对象
            }
        }).start();

        //thread-1
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj2.mm();//使用的锁对象也是obj2对象
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
}
