package com.mystudy.threadmethod.p1currentThread;

public class Test02CurrentThread {
    public static void main(String[] args) throws InterruptedException {
        //创建子线程对象
        SubThread2 thread2 = new SubThread2();
        thread2.setName("thread2");//设置线程的名称
        thread2.start();

        Thread.sleep(500);//main线程睡眠500ms

        //Thread(Runnable)构造方法形参是Runnable接口，调用时传递的实参是接口的实现类对象
        Thread thread3 = new Thread(thread2);
        thread3.start();
    }
}
