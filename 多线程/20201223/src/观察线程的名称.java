public class 观察线程的名称 {
    static class MyThread extends Thread{
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread("海绵宝宝");
        Thread t2 = new MyThread("派大星");

        t1.start();
        t2.start();
    }
}
