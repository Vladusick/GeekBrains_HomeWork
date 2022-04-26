package q3Lesson6HomeWork;

import java.util.Arrays;

public class Task2 {

    public static int[] copyAfter4(int[] array) {

        int indexAfter4 = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                indexAfter4 = i + 1;
                break;
            }
        }
        if (indexAfter4 == -1) {
            throw new RuntimeException("There is no number 4 in the array");
        }
        int[] arrayAfter4 = Arrays.copyOfRange(array, indexAfter4, array.length);
        return arrayAfter4;
    }
}
