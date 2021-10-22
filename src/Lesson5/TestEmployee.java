package Lesson5;

public class TestEmployee {


    public static void main(String[] args) {

        // Employee p1 = new Employee("Vlad", "manager", "sdfsdfsdf", 498494, 464984, 41);

        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Petr Ivanov", "manager", "petr@mail.ru",
                905471211, 123000, 25);
        empArray[1] = new Employee("Kostya Vaschenko", "PR-manager", "Kostyapalka23@mail.ru",
                905457132, 130000, 35);
        empArray[2] = new Employee("Denis Zagrendinov", "worker", "lyapa1992@mail.ru",
                999157324, 70000, 29);
        empArray[3] = new Employee("Vadim Golovach", "teacher", "wood82@mail.ru",
                987514252, 750000, 45);
        empArray[4] = new Employee("Dmitrii Batalov", "mechanic", "half-life2@bk.ru",
                907547421, 80000, 41);

        for (int i = 0; i < empArray.length; i++) {
            if (empArray[i].getAge() > 40) empArray[i].printInfo();
        }


    }

}
