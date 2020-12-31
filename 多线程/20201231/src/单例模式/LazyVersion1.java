package 单例模式;

//懒汉模式

//线程不安全的
public class LazyVersion1 {
    private static LazyVersion1 instance = null;

    public static LazyVersion1 getInstance() {
        //这里是线程不安全的
        if (instance == null) {
            instance = new LazyVersion1();
        }
        return instance;
    }
}
