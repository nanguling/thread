package com.mystudy.volatilekw;

public class Test02 {
    public static void main(String[] args) throws InterruptedException {
        PrintString ps = new PrintString();

        //创建一个子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ps.printStringMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1000);
        System.out.println("mian线程改变打印标志");
        ps.setContinuePrint(false);
        //程序运行后可能会出现死循环的情况
        //原因：main线程修改了打印标志，子线程读取不到
        //解决：使用volatile关键字来修饰打印标志
        //      volatile可以强制线程从公共内存中读取变量的值，而不是从工作内存中读取

    }

    //定义类打印字符串
    static class PrintString{
        private volatile boolean continuePrint = true;

        public void setContinuePrint(boolean continuePrint) {
            this.continuePrint = continuePrint;
        }

        public void printStringMethod() throws InterruptedException {
            System.out.println("子线程开始打印。。。。");
            while (continuePrint) {

            }
            System.out.println("子线程结束打印。。。。");
        }
    }
}
