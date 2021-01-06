package com.mystudy;

import java.util.concurrent.ArrayBlockingQueue;
public class QueueDemo {

    static ArrayBlockingQueue queue = new ArrayBlockingQueue<>(10);

    static class 生产者 extends Thread{
        public 生产者(int i) {
            setName("生产者"+i);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class 消费者 extends Thread{
        public 消费者(int i) {
            setName("消费者"+i);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i < 5;i++) {
            生产者 s = new 生产者(i);
            s.start();
        }

        for (int i = 0; i < 5; i++) {
            消费者 x = new 消费者(i);
            x.start();
        }
    }
}
