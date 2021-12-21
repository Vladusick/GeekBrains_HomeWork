package q2Lesson1;

public class Wall extends Obstacle {

    public Wall(String name) {
        super(name);
    }

    void canJump(String action) {
        System.out.println(action + "Перепрыгнул " + this.name);

    }
}
