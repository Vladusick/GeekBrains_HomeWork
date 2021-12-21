package q2Lesson1;

public class Robot implements Motion {
    String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public String run() {
        return "робот " + this.name + " бежит. ";
    }

    @Override
    public String jump() {
        return "робот " + this.name + " прыгнул. ";
    }
}
