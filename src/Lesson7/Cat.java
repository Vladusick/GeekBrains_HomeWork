package Lesson7;

public class Cat {

    private final String name;
    private final int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public int getAppetite() {
        return appetite;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate) {
        System.out.println("Cat has eaten!");
              plate.decreaseFood(appetite);


    }
}
