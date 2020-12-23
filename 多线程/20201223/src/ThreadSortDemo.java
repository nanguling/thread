import java.util.Random;

public class ThreadSortDemo {

    public static void bubbleSort(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    long tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    private static final Random random = new Random(20201223);

    public static long[] createArr(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(2*n);
        }
        return arr;
    }

    public static void 单线程排序() {
        long[] a1 = createArr(40000);
        long[] a2 = createArr(40000);
        long[] a3 = createArr(40000);
        long[] a4 = createArr(40000);
        long[] a5 = createArr(40000);

        long s = System.currentTimeMillis();
        bubbleSort(a1);
        bubbleSort(a2);
        bubbleSort(a3);
        bubbleSort(a4);
        bubbleSort(a5);
        long e = System.currentTimeMillis();
        double time = (e-s)/1000.0;
        System.out.println("单线程排序耗时:"+time);
    }

    static class SortThread extends Thread{
        private long[] arr;
        SortThread(long[] arr){
            this.arr = arr;
        }

        @Override
        public void run() {
            bubbleSort(arr);
        }
    }

    public static void 多线程排序() throws InterruptedException {
        long[] a1 = createArr(40000);
        long[] a2 = createArr(40000);
        long[] a3 = createArr(40000);
        long[] a4 = createArr(40000);
        long[] a5 = createArr(40000);

        long s = System.currentTimeMillis();
        Thread t1 = new SortThread(a1);
        Thread t2 = new SortThread(a2);
        Thread t3 = new SortThread(a3);
        Thread t4 = new SortThread(a4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        bubbleSort(a5);
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        long e = System.currentTimeMillis();
        double time = (e-s)/1000.0;
        System.out.println("多线程排序耗时:"+time);
    }

    public static void main(String[] args) throws InterruptedException {
        //单线程排序();
        多线程排序();
    }
}
