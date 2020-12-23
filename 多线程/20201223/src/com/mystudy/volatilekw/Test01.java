package com.mystudy.volatilekw;

public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        PrintString ps = new PrintString();
        ps.printStringMethod();

        Thread.sleep(1000);
        ps.setContinuePrint(false);
        //程序根本不会停止，因为在调用打印方法后会一直处于死循环状态
        //解决方法：使用多线程技术
    }

    //定义类打印字符串
    static class PrintString{
        private boolean continuePrint = true;

        public void setContinuePrint(boolean continuePrint) {
            this.continuePrint = continuePrint;
        }

        public void printStringMethod() throws InterruptedException {
            while (continuePrint) {
                System.out.println("main");
                Thread.sleep(500);
            }
        }
    }
}
