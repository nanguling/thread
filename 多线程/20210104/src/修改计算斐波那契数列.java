import java.util.Scanner;

public class 修改计算斐波那契数列 {
    public static long fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n-1) + fib(n - 2);
    }

    static class CalcTask implements Runnable {
        private final int n;
        CalcTask(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            long res = fib(n);
            System.out.printf("fib(%d) = %d\n",n,res);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //ExecutorService thread = Executors.newCachedThreadPool();
        自定义线程池 thread = new 自定义线程池(10);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int n = sc.nextInt();

            CalcTask calcTask = new CalcTask(n);

            //thread.submit(calcTask);
            thread.execute(calcTask);
        }

        thread.shutdown();
    }
}
