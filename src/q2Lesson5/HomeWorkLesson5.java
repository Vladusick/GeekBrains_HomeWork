package q2Lesson5;

import java.util.Arrays;

public class HomeWorkLesson5 extends Thread {

    public static void methodOne() {
        final int size = 10000000;
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) ((arr[i]) * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime + " ms"));
    }

    public static void methodTwo() {

        int size = 10000000;
        float[] arr = new float[size];
        final int halfArrLength = size / 2;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();

        final int halfSize = size / 2;
        float[] leftHalf = new float[halfSize];
        float[] rightHalf = new float[halfSize];

        //Разделяет массивы
        System.arraycopy(arr, 0, leftHalf, 0, halfArrLength);
        System.arraycopy(arr, halfArrLength, rightHalf, 0, halfArrLength);
        float[] mergeArray = new float[size];

        //Запускаем потоки
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < leftHalf.length; i++) {
                leftHalf[i] = (float) ((leftHalf[i]) * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(leftHalf, 0, mergeArray, 0, halfArrLength);
        });


        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < rightHalf.length; i++) {
                rightHalf[i] = (float) ((rightHalf[i]) * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(rightHalf, 0, mergeArray, halfArrLength, halfArrLength);
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime + " ms"));

    }

    public static void main(String[] args) {
        methodOne();
        methodTwo();
    }

}



