package q2Lesson2;

public class Main {

    public static int transformationAndSummation(String[][] array) {

        // Проверка внешнего массива
        if (array.length != 4) {
               throw new MyArraySizeException();
            }

        // Проверка внутренних массивов
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i].length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }

        // Суммирование
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверное значение лежит в ячейке с индексом: " + Integer.toString(i) + "x" + Integer.toString(j) );
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] array = {{"1", "1", "1", "1"},
                            {"1", "1", "1", "1"},
                            {"1", "1", "1", "1"},
                            {"1", "1", "1", "1"}};

        try {
            int result = transformationAndSummation(array);
            System.out.println("Сумма элементов массива = " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}