package lesson;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExmp {
    public static void main(String[] args) {


//        rwLock.writeLock(); // блокирует запись в блок кода
//        rwLock.readLock();  // блокирует чтение из блока кода
    }

    static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock(true);

    static class Read implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                if(rwLock.isWriteLocked()){
                    System.out.println("take lock from write");
                }
                rwLock.readLock().lock();
                System.out.println("work");
                rwLock.readLock().unlock();
            }
        }
    }
}
