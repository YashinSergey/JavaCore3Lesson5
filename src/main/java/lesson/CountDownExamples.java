package lesson;

import java.util.concurrent.CountDownLatch;

public class CountDownExamples {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            final int w = i;
            new Thread((new Runnable() {
                @Override
                public void run() {
                    try {
                        int timer = (int)(Math.random() * 1000);
                        System.out.println(timer);
                        Thread.sleep(timer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cdl.countDown();
                }
            })).start();
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("START!");
    }
}
