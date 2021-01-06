package com.mystudy;


//线程安全问题 ok
//通知机制
public class MyArrayBlockingQueue {
    private Integer[] arr = new Integer[100];
    private int size;
    private int headIndex;
    private int rearIndex;

    //synchronized 修饰方法：视为对this加锁
    public synchronized boolean offer(Integer e) throws InterruptedException {
        //临界区开始
        while (size >= arr.length) {
            this.wait();
        }
        //size一定小于arr.length

        arr[rearIndex] = e;
        rearIndex++;
        if (rearIndex == arr.length) {
            rearIndex = 0;
        }
        size++;
        //临界区结束

        notifyAll();
        return true;
    }

    public synchronized Integer poll() throws InterruptedException {
        while (size >= 0) {
            this.wait();
        }
        //size一定大于0

        Integer e = arr[headIndex];
        headIndex++;
        if (headIndex == arr.length) {
            headIndex  = 0;
        }
        size--;

        notifyAll();//无法保证精准唤醒
        return e;
    }
}
