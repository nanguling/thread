package volatilekw;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用原子类进行自增
 */
public class Test04 {
    public static void main(String[] args) throws InterruptedException {
        //创建十个子线程
        for (int i = 0; i < 100; i++) {
            new MyThread().start();
        }

        //主线程睡眠1秒种
        Thread.sleep(1000);
        System.out.println(MyThread.count.get());
    }

    //创建子线程
    static class MyThread extends Thread {
        //使用AtomicInteger对象
        public static AtomicInteger count = new AtomicInteger();

        public static void AddCount() {
            for (int i = 0; i < 1000; i++) {
                //相当于后置自增 count++
                count.getAndIncrement();
            }
            System.out.println(Thread.currentThread().getName()+" count=="+count.get());
        }

        @Override
        public void run() {
            AddCount();
        }
    }
}
