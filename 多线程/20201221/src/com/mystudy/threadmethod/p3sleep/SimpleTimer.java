package com.mystudy.threadmethod.p3sleep;

/**
 * 使用线程休眠完成一个简易的计时器
 */
public class SimpleTimer {
    public static void main(String[] args) {

        int remaining = 10;//从60秒开始计时
        //读取main方法的参数
        if (args.length == 1) {
            remaining = Integer.valueOf(args[0]);
        }

        while (true) {
            System.out.println("Remaining:"+remaining);
            remaining--;
            if (remaining < 0) {
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done!");
    }
}
