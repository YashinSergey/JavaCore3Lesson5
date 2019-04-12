package lesson;

public class PriorityExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println(1);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                System.out.println(2);
            }
        });

        Thread t3 = new Thread(new Runnable() {
            public void run() {
                System.out.println(3);
            }
        });

        t1.setPriority(10);
        t2.setPriority(5);
        t3.setPriority(1);

        t1.start();
        t2.start();
        t3.start();
    }
}
