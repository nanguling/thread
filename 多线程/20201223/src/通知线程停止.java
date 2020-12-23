/**
 * intrrupt()方法：
 *  1.线程处于RUANNABLE状态，通过获取当前中断状态来决定线程是否关闭
 *  2.线程处于BLOCKED状态，通过捕捉InterruptedException来决定线程是否关闭
 *
 *  注意：如果已经以InterruptedException的方式通知，中断状态就不在设置
 */
public class 通知线程停止 {
    static class MyThread extends Thread{
        @Override
        public void run() {
            while (true) {
                //线程处于BLCOKED状态
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("子线程即将从BLOCKED状态关闭...");
                    break;
                }

                //线程处于RUNNABLE状态
                if (Thread.interrupted()) {
                    System.out.println("子线程即将从RUNNABLE状态关闭....");
                    break;
                }
                System.out.println("hello word");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();

        Thread.sleep(2000);

        //2秒后关闭子线程
        t.interrupt();
    }
}
