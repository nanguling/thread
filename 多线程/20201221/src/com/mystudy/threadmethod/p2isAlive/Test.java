package com.mystudy.threadmethod.p2isAlive;

/**
 * 测试线程的活动状态
 */
public class Test {
    public static void main(String[] args) {
        Thread thread = new SubThread3();
        System.out.println("begin=="+thread.isAlive());//启动线程之前肯定是false
        thread.start();
        System.out.println("end=="+thread.isAlive());//结果不一定，打印这一行时，如果thread3线程还未结束返回ture，如果已结束就返回false
    }
}
