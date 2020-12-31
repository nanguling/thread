package 单例模式;

//线程安全的懒汉模式
//性能不高
public class LazyVersion2 {
    private static LazyVersion2 instance = null;

    public static LazyVersion2 getInstance() {

        //这里加锁可能导致每次都会发生争夺锁情况，但实际上只需要有一次争夺就行了
        synchronized (LazyVersion2.class) {
            if (instance == null) {
                instance = new LazyVersion2();
            }
        }
        return instance;
    }
}
