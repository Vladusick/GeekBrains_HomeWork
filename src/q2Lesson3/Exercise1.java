package q2Lesson3;

import java.util.*;

public class Exercise1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("БИ-2");
        list.add("Ночные снайперы");
        list.add("Звери"); // Повторяется 2 раза
        list.add("Мумий Тролль");
        list.add("Ляпис Трубецкой");
        list.add("Валентин Стрыкало");
        list.add("Звери");
        list.add("Arctic Monkeys"); // Повторяется 2 раза
        list.add("Franz Ferdinand");
        list.add("Arctic Monkeys");

        System.out.println("Исходный массив:");
        System.out.println(list);
        System.out.println(" ");
        System.out.println("Уникальные элементы массива:");

        Set<String> stringSet = new HashSet<>(list);
        System.out.println(stringSet);

        System.out.println(" ");

        for (String s:list) {
            System.out.println("Количество входждений элемента: " + s + " = " + Collections.frequency(list,s));

        }

    }

}
