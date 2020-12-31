package 单例模式;

//线程安全
//构造的早，如果不使用就会造成空间浪费
public class 饿汉模式 {
    private 饿汉模式() {}

    private static 饿汉模式 instance = new 饿汉模式();//只会存在一个对象

    private static 饿汉模式 getInstance() {
        return instance;
    }
}
