package q2Lesson3;

import java.util.Set;

public class PhonebookTest {

    public static void main(String[] args) {
        PhoneBook phonebook = new PhoneBook();

        phonebook.add("Иванов", "795474");
        phonebook.add("Иванов", "123");
        phonebook.add("Иванов", "123");

        phonebook.add("Петров", "777");
        phonebook.add("Сидоров", "999");

        Set<String> allSurnames = phonebook.getAllSurnames();
        for (String surname : allSurnames) {
            System.out.printf("Пользователь %s имеет номер(а) телефона %s %n", surname, phonebook.get(surname));

        }

        System.out.println("----------");

        System.out.println(phonebook.get("Иванов"));

    }

}
