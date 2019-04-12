package lesson;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(5);

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
                    try {
                        cb.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("END");
                }
            })).start();
        }

    }
}
