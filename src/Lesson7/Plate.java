package Lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void decreaseFood(int foodCount) {
        this.food -= foodCount;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
