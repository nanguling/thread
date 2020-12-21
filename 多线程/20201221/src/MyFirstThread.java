public class MyFirstThread {
    public static void main(String[] args) {
        Thread thread = new Thread();//新建状态
        thread.start();//让新建的线程（子线程）的状态变成就绪状态
    }
}
