package homework;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static int NA_START = 0;
    private static CyclicBarrier cyclicbarrier;

    static void setCyclicBarrier(CyclicBarrier cyclicbarrier) {
        Car.cyclicbarrier = cyclicbarrier;
    }
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;

    String getName() {
        return name;
    }

    int getSpeed() {
        return speed;
    }

    Race getRace() {
        return race;
    }

    Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        System.out.println(this.name + " скорость -> " + this.speed);
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            NA_START++;
            if (CARS_COUNT == NA_START){
                System.out.println("ВАЖНОЕ ОБЪЯВЕНИЕ >>> Гонка началась!!!");
            }
            cyclicbarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
    }
}
