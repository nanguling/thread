import java.util.Scanner;

public class 利用多线程计算fib数列 {

    public static long fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            Thread thread = new MyThread(n);
            thread.start();
        }
    }

    static class MyThread extends Thread {
        private int n;
        MyThread(int n) {
            this.n = n;
        }
        @Override
        public void run() {
            System.out.println(fib(n));
        }
    }
}
