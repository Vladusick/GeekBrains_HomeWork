import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import q3Lesson6HomeWork.Task2;

public class Task2Test {
    private Task2 task2;

    @Test
    public void task2Test1() {
        task2 = new Task2();
        int[] verifiableArray = {1, 2, 4, 0, 4, 2, 4, 0,};
        int[] correctResult = {0};
        Assertions.assertArrayEquals(correctResult, task2.copyAfter4(verifiableArray));
    }

    @Test
    public void task2Test2() {
        task2 = new Task2();
        int[] verifiableArray = {4, 2, 4, 0, 4, 2, 5, 0,};
        int[] correctResult = {2, 5, 0};
        Assertions.assertArrayEquals(correctResult, task2.copyAfter4(verifiableArray));
    }

    @Test
    public void task2Test3() {
        task2 = new Task2();
        int[] verifiableArray = {1, 4, 9, 0, 1, 2, 5, 0};
        int[] correctResult = {9, 0, 1, 2, 5, 0};
        Assertions.assertArrayEquals(correctResult, task2.copyAfter4(verifiableArray));
    }

    @Test
    public void task2Test4() {
        task2 = new Task2();
        int[] verifiableArray = {1, 2, 4, 0, 4, 9, 0, 4, 2, 5, 0};
        int[] correctResult = {2, 5, 0};
        Assertions.assertArrayEquals(correctResult, task2.copyAfter4(verifiableArray));
    }
}
