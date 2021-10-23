package Lesson6;

public class Animal {
    private String name;
    private String color;
    private int age;
    private int staminaRun;
    private int staminaSwim;

    public Animal() {
    }

    public Animal(String name, String color, int age, int staminaRun, int staminaSwim) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.staminaRun = staminaRun;
        this.staminaSwim = staminaSwim;
    }

    public void run(int staminaRun) {
        System.out.println(name + " пробежал " + staminaRun + " метров");
    }

    public void swim(int staminaSwim) {
        System.out.println(name + " проплыл " + staminaSwim + " метров");
    }

     public int getStaminaRun() {
       return staminaRun;
    }

     public int getStaminaSwim() {
        return staminaSwim;
    }

    public String getName() {
        return name;
    }

}



