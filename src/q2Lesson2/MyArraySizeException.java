package q2Lesson2;

public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException() {
        super("Неверный размер массива, должнен быть 4х4");
    }
}
