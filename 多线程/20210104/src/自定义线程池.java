import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
/*
    1.固定大小
    2.提前雇人
    3.雇员不解散
 */
public class 自定义线程池 {
    //员工花名册
    private Thread[] threads;
    //存在“待完成”任务的队列
    private BlockingQueue<Runnable> queue;


    static class WorkerThread extends Thread{
        //存在“待完成”任务的队列，大家共享一个队列
        private BlockingQueue<Runnable> queue;

        WorkerThread(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
                try {
                    //只要没有中断之前就一直执行任务队列里的任务
                    while (!Thread.interrupted()) {
                        //领取任务
                        Runnable take = queue.take();
                        //完成任务
                        take.run();
                    }
                }catch (InterruptedException e) {

                }
        }
    }


    public 自定义线程池(int nThreads) {
        //提前创建 nThreads个线程
        //构造花名册
        threads = new Thread[nThreads];

        //构造任务队列
        queue = new LinkedBlockingDeque<>();

        //雇佣员工
        for (int i = 0; i < nThreads; i++) {
            //雇佣
            Thread worker = new WorkerThread(queue);
            //让员工开始上岗
            worker.start();
            //把员工记录在花名册
            threads[i] = worker;
        }
    }

    public void execute(Runnable runnable) throws InterruptedException {
        //只需要把任务放进任务对列中，就有员工找时间来完成任务
        queue.put(runnable);
    }

    public void shutdown() throws InterruptedException {
        //先通知花名册上的每个员工结束工作
        for (Thread thread:threads) {
            thread.interrupt();
        }
        //等待每个员工结束
        for (Thread thread:threads) {
            thread.join();
        }
    }

}
