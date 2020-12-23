package com.mystudy.intrinsiclock;

/**
 * synchronized同步代码块
 * this锁对象
 * 1.假设thread-0线程获得cpu执行权，调用obj的mm方法，执行方法体，要先获得this对象obj的锁，执行for循环
 * 2.假设thread-0在执行for循环期间，thread-1获得了cpu的执行权，调用obj的mm方法，执行方法体，要先获得this对象obj的锁，执行方体。
 *   但是现在thread-0线程持有this对象obj的锁，synchronized内部锁是排他锁，只能有一个线程持有，thread-1进入等待区等待this对象obj的锁。
 * 3.当thread-0线程重新获得cpu执行权，把for循环执行完毕，即完成同步代码块，释放了this对象obj的锁。
 * 4.等待区的thread-1会获得this对象obj的锁
 *
 */
public class Test01 {
    public static void main(String[] args) {
        //创建两个线程分别调用mm方法
        //先创建Test01对象，通过对象调用这个方法
        Test01 obj = new Test01();

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
                obj.mm();//使用的锁对象也是obj对象
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
