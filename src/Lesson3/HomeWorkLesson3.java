package Lesson3;

import java.sql.Array;

public class HomeWorkLesson3 {

    public static void main(String[] args) {

        arrayReturn(5,41);

        // Задание 1
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) array[i] = 0;
            else if (array[i] == 0) array[i] = 1;
            System.out.print(array[i]);
        }
        System.out.println(" ");
        System.out.println(" ");

        // Задание 2
        int[] mass = new int[100];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = i + 1;
            System.out.println(mass[i]);
        }
        System.out.println(" ");
        System.out.println(" ");

        // Задание 3
        int[] massiv = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < massiv.length; i++) {
            if (massiv[i] < 6) massiv[i] = massiv[i] * 2;
            System.out.println(massiv[i]);
        }
        System.out.println(" ");
        System.out.println(" ");

        // Задание 4
        int arraySize = 5;
        int[][] doublemass = new int[arraySize][arraySize];
        for (int i = 0; i < doublemass.length; i++) {
            for (int j = 0; j < doublemass[i].length; j++) {
                if (i == j) {
                    doublemass[i][j] = 1;
                }
                if (i + j == arraySize - 1) {
                    doublemass[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < doublemass.length; i++) {
            for (int j = 0; j < doublemass[i].length; j++) {
                System.out.print(doublemass[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(" ");
        System.out.println(" ");

        // Задание 6
        int[] data = {1, 5, 3, 2, 101, 4, 5, 2, 4, 0, 9, 1};
        int min = data[0];
        int max = data[1];
        for (int i = 0; i < data.length; i++) {
            if (min > data[i]) min = data[i];
        }
        for (int i = 0; i < data.length; i++) {
            if (max < data[i]) max = data[i];
        }
        System.out.println("min element = " + min);
        System.out.println("max element = " + max);
        System.out.println(" ");
        System.out.println(" ");

// Заданние 7 не доделал

        int[] data2 = {1, 43, 5, 0, 432, 3, 5};
        int shift = 3;
        int firstElement = data[0];
        for (int i = 0; i < data2.length - shift; i++) {
            data2[i] = data2[i + shift];
        }
        data2[data2.length-shift] = firstElement;
        for (int i = 0; i < data2.length; i++) {
            System.out.println(data2[i]);
        }
    }
    // задание 5
    public static int[] arrayReturn(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
            System.out.println(array[i]);
        }
        return (array);
    }

    }


