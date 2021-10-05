package Lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {
        threeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void threeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 3;
        int b = 5;
        int sum = a + b;
        if (sum >= 0) System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
    }

    public static void printColor() {
        int value = 50;
        if (value <= 0) System.out.println("Красный");
        else if (value <= 100) System.out.println("Желтый");
        else if (value > 100) System.out.println("Зелетый");
    }

    public static void compareNumbers() {
        int a = 5;
        int b = 10;
        if (a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }
}
