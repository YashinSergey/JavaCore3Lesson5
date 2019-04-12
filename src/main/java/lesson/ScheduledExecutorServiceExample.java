package lesson;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {  // Schedule - график, Scheduled - по графику, по расписанию
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 18);
        calendar.set(Calendar.MINUTE, 24);
        calendar.set(Calendar.SECOND, 0);

        Date time = calendar.getTime();
        Timer timer = new Timer();

        timer.schedule(new RemindTask(), time);

    }

    private void firstExmp(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ла-ла");
            }
        });
                ScheduledExecutorService serv = Executors.newScheduledThreadPool(5, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        });
        serv.scheduleAtFixedRate(t1, 1000,2000,
                TimeUnit.MILLISECONDS);  // Запускает следующий поток в конкретное время,
                                         // независимо от выполнения других потоков

        serv.scheduleWithFixedDelay(t1, 1000,2000,
                TimeUnit.MILLISECONDS);  // Запускает следующий поток через установленное время
                                        // после завершения предидущего потока

    }
}

class RemindTask extends TimerTask{
    @Override
    public void run() {
        System.out.println("Время!");
    }
}
