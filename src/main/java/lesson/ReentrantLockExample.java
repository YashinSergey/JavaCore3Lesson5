package lesson;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        ReentrantLock rl = new ReentrantLock(); // блокирует участок кода, находящийся между lock() и unlock()

         new Thread(new Runnable() {
             @Override
             public void run() {
                 rl.lock();
                 System.out.println(1);
                 try {
                     Thread.sleep(2000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 System.out.println(2);
                 rl.unlock();
             }
         }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                rl.lock();
                System.out.println(3);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(4);
                rl.unlock();
            }
        }).start();
    }
}
