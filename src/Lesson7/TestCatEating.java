package Lesson7;

public class TestCatEating {

    public static void main(String[] args) {
             Cat cat = new Cat("Barsik", 10, false);
        Plate plate = new Plate(50);
        Cat[] catArray = new Cat[3];
       catArray[0] = new Cat("Murka", 20, false);
       catArray[1] = new Cat("Milka", 20, false);
       catArray[2] = new Cat("Barsik", 30, false);

        plate.info();

        for (int i = 0; i < catArray.length; i++) {
            catArray[i].eat(plate);
            plate.info();
        }

     //  plate.info();
      //  catArray[0].eat(plate);
     //  plate.info();
     //  catArray[1].eat(plate);
      //  plate.info();
      //  catArray[2].eat(plate);

        //    if (plate.getFood() >= cat.getAppetite()) {

        //       plate.setFood(plate.getFood() - cat.getAppetite());
         // cat.eat(plate);


        //   }

        plate.info();
    }
}
