package com.mystudy.createthread.p3;

/**
 * 当线程类已经有父类了，就不能用继承Thread类的形式创建线程，可以使用实现Runnable接口的形式
 * 1.定义类实现Runnable接口
 */
public class MyRunnable implements Runnable {
    //2.重写Runnable接口中的抽象方法run()，run方法就是子线程要执行的代码
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            System.out.println("sub thread-->"+i);
        }
    }
}
