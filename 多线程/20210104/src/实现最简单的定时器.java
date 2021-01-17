public class 实现最简单的定时器 {
    static abstract class TimerTask{
        protected abstract void run();
    }

    static class Timer{
        public void schedule(TimerTask task,long delay) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(delay);
                        task.run();
                    }catch (InterruptedException e) {

                    }
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            protected void run() {
                System.out.println("醒了吗？哥");
            }
        };

        timer.schedule(task,5000);

        while (true) {
            System.out.println("睡觉...");
            Thread.sleep(1000);
        }
    }
}
