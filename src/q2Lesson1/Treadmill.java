package q2Lesson1;

public class Treadmill extends Obstacle {

    public Treadmill(String name) {
        super(name);
    }

    void canRun(String action) {
        System.out.println(action + "Перебежал " + this.name);

    }

}
