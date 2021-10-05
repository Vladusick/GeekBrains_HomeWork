package Lesson2;

public class HomeWorkLesson2 {
    public static void main(String[] args) {

        boolean j = inRage(5, 100);
        System.out.println(j);
        nunber(-5);
        boolean h = plusMinus(-5);
        System.out.println(h);
        printLine("test", 3);
        boolean x = isLeap(2300);
        System.out.println(x);
    }

    // Задание 1
    public static boolean inRage(int a, int b) {
        int sum = a + b;
        boolean result;
        if (sum >= 10 && sum <= 20) result = true;
        else result = false;
        return result;
    }

    // Задание 2
    public static void nunber(int a) {
        if (a < 0) System.out.println("Число отрицательное");
        else System.out.println("Число положительное");
    }

    // Задание 3
    public static boolean plusMinus(int a) {
        boolean result;
        if (a < 0) result = false;
        else result = true;
        return result;
    }

    // Задание 4
    public static void printLine(String s, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(s);
        }
    }

    // Задание 5
    public static boolean isLeap(int year) {
        boolean result = false;
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) result = true;
        return result;

    }
}

