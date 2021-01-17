import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 精准控制线程顺序 {
    private static Lock lock = new ReentrantLock();
    public static String siganl;

    static class AThread extends Thread {
        @Override
        public void run() {

            /*synchronized (this) {
                if ("A".equals(siganl)) {
                    return;
                }
            }*/

            lock.lock();//申请锁
            while (!"A".equals(siganl)) {
                //释放锁
                lock.unlock();
                Thread.yield();//放弃cpu资源
                lock.lock();
            }

            //此时持有锁

            System.out.println("A线程正在运行");
            siganl = "B";//切换信号

            //释放锁
            lock.unlock();
        }
    }

    static class BThread extends Thread {
        @Override
        public void run() {
            lock.lock();//申请锁
            while (!"B".equals(siganl)) {
                //释放锁
                lock.unlock();
                Thread.yield();//放弃cpu资源
                lock.lock();
            }

            //此时持有锁

            System.out.println("B线程正在运行");
            siganl = "C";//切换信号

            //释放锁
            lock.unlock();
        }
    }

    static class CThread extends Thread {
        @Override
        public void run() {
            lock.lock();//申请锁
            while (!"C".equals(siganl)) {
                //释放锁
                lock.unlock();
                Thread.yield();//放弃cpu资源
                lock.lock();
            }

            //此时持有锁

            System.out.println("C线程正在运行");
            siganl = "A";//切换信号

            //释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Queue<String > queue = new LinkedList<>();
        queue.add("C");
        queue.add("A");
        queue.add("B");
        while (true) {
            Thread.sleep(2000);
            String s = queue.poll();
            siganl = s;
            queue.add(siganl);
            new AThread().start();
            new BThread().start();
            new CThread().start();
        }

    }
}
