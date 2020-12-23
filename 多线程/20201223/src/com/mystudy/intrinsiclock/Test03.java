package com.mystudy.intrinsiclock;

/**
 * synchronized同步代码块
 * 使用常量对象作为锁对象
 */
public class Test03 {
    public static void main(String[] args) {
        //创建两个线程分别调用mm方法
        //先创建Test01对象，通过对象调用这个方法
        Test03 obj = new Test03();
        Test03 obj2 = new Test03();

        //thread-0
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj.mm();//使用的锁对象也是OBJ常量对象
            }
        }).start();

        //thread-1
        new Thread(new Runnable() {
            @Override
            public void run() {
                obj2.mm();//使用的锁对象也是OBJ常量对象
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
}
