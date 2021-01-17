import java.util.Timer;
import java.util.TimerTask;

public class 使用java中的定时器 {
    public static void main(String[] args) throws InterruptedException {
        //TimerTask; //让定时器去运行的任务
        //Timer; //定时器

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("醒了吗?哥");
            }
        };

        Timer timer = new Timer();
        //timer.schedule(timerTask,5000);
        timer.scheduleAtFixedRate(timerTask,5000,3000);

        while (true) {
            System.out.println("睡觉...");
            Thread.sleep(1000);
        }
    }
}
