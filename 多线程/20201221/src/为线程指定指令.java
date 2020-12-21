public class 为线程指定指令 {

    static class MyThread extends Thread{
        @Override
        public void run() {
            while (true) {
                System.out.println("我是子线程");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
        while (true) {
            System.out.println("我是父线程");
        }
    }
}
