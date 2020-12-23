package com.mystudy.intrinsiclock;

/**
 * 脏读
 *  读取属性值出现了一些意外，读取的是中间值而不是修改之后的值
 *  出现脏读的原因：对共享数据的修改与对共享数据的读取不同步
 *  解决方法：
 *      不仅对【修改数据】的代码块进行同步，还要对【读取数据】的代码块同步。
 */
public class Test08 {
    public static void main(String[] args) throws InterruptedException {
        PublicValue publicValue = new PublicValue();
        MyThread thread = new MyThread(publicValue);
        thread.start();

        Thread.sleep(100);
        publicValue.getValue();
    }

    //定义线程，设置用户名和密码
    static class MyThread extends Thread{
        private PublicValue publicValue;
        MyThread(PublicValue publicValue) {
            this.publicValue = publicValue;
        }
        @Override
        public void run() {
            publicValue.setValue("aaaa","666");
        }
    }

    static class PublicValue{
        private String name = "ssss";
        private String pwd = "123";

        public synchronized void getValue() {
            System.out.println(Thread.currentThread().getName()+",getter name-->"+name+",pwd-->"+pwd);
        }

        public synchronized void setValue(String name,String pwd) {
            this.name = name;
            try {
                Thread.sleep(1000);//模拟操作name属性需要一定时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.pwd = pwd;
            System.out.println(Thread.currentThread().getName()+",setter name-->"+name+",pwd-->"+pwd);
        }
    }
}
