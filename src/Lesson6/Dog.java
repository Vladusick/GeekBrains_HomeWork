package Lesson6;

public class Dog extends Animal {

    public Dog(String name, String color, int age, int staminaRun, int staminaSwim) {
        super(name, color, age, staminaRun, staminaSwim);
    }

    @Override
    public void run(int getStaminaRun) {
        if (getStaminaRun >= 500) {
            System.out.println(getName() + " не пробежал из за ограничения 500 м");
        } else super.run(getStaminaRun);
    }

    @Override
    public void swim(int getStaminaSwim) {
        if (getStaminaSwim >= 10) {
            System.out.println(getName() + " не проплыл из за ограничения 10 м");
        } else super.swim(getStaminaSwim);
    }

}



