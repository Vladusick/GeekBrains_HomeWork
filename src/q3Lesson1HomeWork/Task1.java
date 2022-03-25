package q3Lesson1HomeWork;

public class Task1 {

    private static <T> void swap(T[] array, int index1, int index2) {

        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3};
        String[] strArray = {"One", "Two", "Three"};

        swap(intArray, 0, 2);
        swap(strArray, 0, 2);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }
    }
}
