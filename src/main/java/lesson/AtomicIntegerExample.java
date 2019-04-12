package lesson;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(100); // Integer, синхронизированый для всех потоков
        System.out.println(ai);

        ai.compareAndSet(100,102); // меняем значение со 100 на 102
        System.out.println(ai);

        ai.incrementAndGet(); // увеличиваем значение на еденицу (инкремент). Обычный оператор ++ здесь не работает
        System.out.println(ai);

    }
}
