package q3Lesson1HomeWork;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public static void main(String[] args) {

        Integer[] IntArray = new Integer[3];
        IntArray[0] = 1;
        IntArray[1] = 2;
        IntArray[2] = 3;

        String[] stringArray = new String[3];
        stringArray[0] = "One";
        stringArray[1] = "Two";
        stringArray[2] = "Three";

        System.out.println("Лист получился = " + arrayToList(IntArray));
        System.out.println("Лист получился = " + arrayToList(stringArray));

        }

    public static <E> List<E> arrayToList(E[] array) {
        List<E> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            result.add(array[i]);
        }
        return result;
    }
}
