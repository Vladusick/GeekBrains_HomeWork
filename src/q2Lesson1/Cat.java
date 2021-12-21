package q2Lesson1;

public class Cat implements Motion {
    String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String run() {
        return "кот " + this.name + " бежит. ";
    }

    @Override
    public String jump() {
        return "кот " + this.name + " прыгает. ";
    }

    // свой метод не имплементированный, можно удлаить
    public void jump2() {
        System.out.println("кот " + this.name + " перепрыгнул");
    }


}
