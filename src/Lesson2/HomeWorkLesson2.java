package Lesson2;

public class HomeWorkLesson2 {
    public static void main(String[] args) {

        boolean j = isInRange(5, 10);
       //  System.out.println(j);
      //  number(-5);
     //   boolean h = isNegative(11);
     //   System.out.println(h);
       // printLine("test", 3);
     //   boolean x = isLeap(2400);
     //   System.out.println(x);
    }

    // Задание 1
    public static boolean isInRange(int a, int b) {
        int sum = a + b;
        return (sum >= 10 && sum <= 20);
    }

    // Задание 2
    public static void number(int a) {
        if (a < 0) System.out.println("Число отрицательное");
        else System.out.println("Число положительное");
    }

    // Задание 3
    public static boolean isNegative(int a) {
        return a < 0;
    }

    // Задание 4
    public static void printLine(String s, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(s);
        }
    }

    // Задание 5
    public static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;

    }
}

