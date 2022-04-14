package q3Lesson7HomeWork;

import q3Lesson7HomeWork.myTesting.TestsHandler;

public class Main {
    public static void main(String[] args) {

        ClassForTesting classForTesting = new ClassForTesting();
        TestsHandler.start(classForTesting.getClass());


        System.out.println();
        ClassExplorer.outClassInfo(String.class);
    }
}