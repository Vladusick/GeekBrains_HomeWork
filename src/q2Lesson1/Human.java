package q2Lesson1;

public class Human implements Motion {
    String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public String run() {
        return "человек " + this.name + " бежит. ";
    }

    @Override
    public String jump() {
        return "человек " + this.name + " прыгнул. ";
    }
}
