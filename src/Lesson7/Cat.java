package Lesson7;

public class Cat {

    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public int getAppetite() {
        return appetite;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= getAppetite()) {
            System.out.println(name + " Поела!");
            plate.decreaseFood(appetite);
            satiety = true;
            System.out.println(name + " Сытость = " + satiety);
        } else System.out.println(name + " Не поел, еды мало, Cытость = " + satiety);


    }
}
