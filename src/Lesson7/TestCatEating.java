package Lesson7;

public class TestCatEating {

    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 5);
        Plate plate = new Plate(10);

        plate.info();
        if (plate.getFood() > cat.getAppetite()) {
   //         cat.eat();
     //       plate.setFood(plate.getFood() - cat.getAppetite());
            cat.eat(plate);
        }
        plate.info();
    }
}
