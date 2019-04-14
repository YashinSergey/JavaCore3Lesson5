package homework;

public class Road extends Stage {
    private static  boolean FINISH = false;
    Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            if(c.getRace().getStages().size() -1  == c.getRace().getStages().indexOf(this)&& !FINISH){
                FINISH = true;
                System.out.println(c.getName() + " Победил!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
