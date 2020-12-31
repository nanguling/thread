package 单例模式;


public class LazyVersion4 {
    //使用volatile关键字的作用：
    //保证instance = new LazyVersion4(); 一定是按照 1-->2-->3的顺序执行的。
    //确保不会出现另一个线程在使用instance对象的时候，该对象还没被初始化完毕。
    private static volatile LazyVersion4 instance = null;

    public static LazyVersion4 getInstance() {

            if (instance == null) {

                synchronized (LazyVersion4.class) {
                    if (instance == null) {
                        instance = new LazyVersion4();
                    }
                }
            }
        return instance;
    }
}
