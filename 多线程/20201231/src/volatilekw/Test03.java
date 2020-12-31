package volatilekw;

/**
 * volatile不具备原子性
 */
public class Test03 {
    public static void main(String[] args) {
        //创建十个子线程
        for (int i = 0; i < 100; i++) {
            new MyThread().start();
        }
    }

    //创建子线程
    static class MyThread extends Thread {
        //volatile关键字仅仅是表示所有线程从主内存中读取count变量的值
        //private volatile static int count;
        private static int count;

        //这段代码运行后它不是线程安全的，想要线程安全需要使用synchronized关键字进行同步，也就不需要volatile关键字了
        /*public static void AddCount() {
            for (int i = 0; i < 1000; i++) {
                //count++ 不是原子操作
                count++;
            }
            System.out.println(Thread.currentThread().getName()+" count=="+count);
        }*/

        public synchronized static void AddCount() {
            for (int i = 0; i < 1000; i++) {
                //count++ 不是原子操作
                count++;
            }
            System.out.println(Thread.currentThread().getName()+" count=="+count);
        }

        @Override
        public void run() {
            AddCount();
        }
    }
}
