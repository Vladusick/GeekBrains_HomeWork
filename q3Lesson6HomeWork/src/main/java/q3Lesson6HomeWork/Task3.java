package q3Lesson6HomeWork;

import java.util.Arrays;

public class Task3 {

    public boolean examinationArray (int[] array) {
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1 || array[i] == 4) check = true;
         } return check;
    }
}