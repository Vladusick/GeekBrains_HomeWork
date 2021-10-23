package Lesson6;

import java.util.Random;

public class TestLesson6 {
    public static void main(String[] args) {
        Random random = new Random();

        Cat barsik = new Cat("Барсик", "Рыжий", 4, random.nextInt(300), random.nextInt(100));
        Dog bobik = new Dog("Бобик", "Серый", 6, random.nextInt(1000), random.nextInt(20));

        barsik.run(barsik.getStaminaRun());
        barsik.swim(barsik.getStaminaSwim());
        bobik.run(bobik.getStaminaRun());
        bobik.swim(bobik.getStaminaSwim());


    }


}


