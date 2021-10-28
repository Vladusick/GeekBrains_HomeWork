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
        this.food = food - foodCount;
    }

    public void info() {
        System.out.println("Еда в тарелке = " + food);
    }

    public void addFood(int number) {
        this.food = food + number;
        System.out.println("Еда в тарелке добавилась на " + number);

    }

}
