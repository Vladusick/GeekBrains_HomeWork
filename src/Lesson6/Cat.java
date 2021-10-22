package Lesson6;

public class Cat extends Animal {

    public Cat(String name, String color, int age, int staminaRun, int staminaSwim) {
        super(name, color, age, staminaRun, staminaSwim);
    }

    @Override
    public void run(int getStaminaRun) {
        if (getStaminaRun >= 200) {
            System.out.println(name + " не пробежал из за ограничения 200 м");
        } else super.run(getStaminaRun);
    }

    @Override
    public void swim(int getStaminaSwim) {
        System.out.println(name + " не умеет плавать");
    }

}

