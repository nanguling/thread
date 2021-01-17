import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor的使用 {
    public static void main(String[] args) {
        ExecutorService t1 = Executors.newCachedThreadPool();
        ExecutorService t2 = Executors.newFixedThreadPool(10);
        ExecutorService t3 = Executors.newSingleThreadExecutor();
    }
}
