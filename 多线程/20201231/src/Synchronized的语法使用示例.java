public class Synchronized的语法使用示例 {
    //同步方法
    synchronized int fun1() {
        return 0;
    }
    synchronized static void fun2() {

    }

    //同步代码块
    static void fun3() {
        Object object = new Object();
        synchronized(object)  {

        }
    }
}
