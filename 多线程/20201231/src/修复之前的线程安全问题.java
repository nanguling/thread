public class 修复之前的线程安全问题 {
    public static final int COUNT = 100000;
    public static int n = 0;
    public static Object lock = new Object();

    static class Add extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                synchronized (lock) {
                    n++;
                }
            }
        }
    }


    static class Sub extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                synchronized(lock) {
                    n--;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Add();
        Thread t2 = new Sub();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(n);
    }
}
