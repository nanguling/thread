package 单例模式;

//1.为什么要二次判断
//2.性能是怎么提高的
//3.instance = new LazyVersion3();可能会被重排序
public class LazyVersion3 {
    private static LazyVersion3 instance = null;

    public static LazyVersion3 getInstance() {

            if (instance == null) {

                synchronized (LazyVersion3.class) {
                    //二次判断
                    //可以解决每次都会争夺该锁的问题，从而确保性能提高
                    if (instance == null) {
                        //这里重排序可能导致另一个线程在使用该对象时，该对象还没有被初始化完成
                        instance = new LazyVersion3();
                    }
                }
            }
        return instance;
    }
}
