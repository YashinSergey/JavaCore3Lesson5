package lesson;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class CollectionsExamples {
    public static void main(String[] args) {


    }

    private void arrayBlockQueueExmp(){
        ArrayBlockingQueue<String> arrbq = new ArrayBlockingQueue<>(10);
        arrbq.add("asd"); // Добавляет элемент, если есть свободная ячейка. Если её нет, получаем исключение
        arrbq.offer("kds"); // Добавляет элемент, если есть свободная ячейка. Если её нет,
        // ошибок не возникает, просто возвращает false
        try {
            arrbq.offer("huu", 50, TimeUnit.MILLISECONDS);// Добавляет элемент, если есть свободная ячейка.
            // Если её нет, offer будет ждать в течении 50
            // миллисекунд. Если по истечении этого времени ячейка
            // не освободится, то он вернёт false

            arrbq.put("Queue"); // Добавляет элемент, если есть свободная ячейка. Если её нет, ставит запрос в очередь и
            // ждет пока одна из ячеек не освободится
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void cuncurrentHashMapExmp(){
        ConcurrentHashMap<String,String> conhm = new ConcurrentHashMap<>(); // Блокирует отдельный элементы

        Map<String, String> hm = Collections.synchronizedMap(new HashMap<>()); // Блокирует всю коллекцию
    }
}
