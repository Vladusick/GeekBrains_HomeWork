import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import q3Lesson6HomeWork.Task3;

public class Task3Test {
    private Task3 task3;

    @Test
    public void task3Test1() {
        task3 = new Task3();
        int[] array = {1, 2, 3, 0};
        Assertions.assertEquals(true, task3.examinationArray(array));
    }

    @Test
    public void task3Test2() {
        task3 = new Task3();
        int[] array = {0, 7, 3, 0};
        Assertions.assertEquals(false, task3.examinationArray(array));
    }

    @Test
    public void task3Test3() {
        task3 = new Task3();
        int[] array = {4, 2, 3, 0};
        Assertions.assertEquals(true, task3.examinationArray(array));
    }

    @Test
    public void task3Test4() {
        task3 = new Task3();
        int[] array = {1, 1, 4, 4};
        Assertions.assertEquals(true, task3.examinationArray(array));
    }
}
