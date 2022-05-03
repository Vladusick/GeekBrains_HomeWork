package jdbc;

import java.util.Scanner;

public class Loop {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        //   NoteServiceBase noteService = new NoteServiceBase();
        JDBC jdbc = new JDBC();
        Commands commands = new Commands();

        System.out.println("Вас приветствует консольное приложение - СПИСОК ЗАМЕТОК");
        System.out.println(" - - - ");
        System.out.println("Чтобы получить список всех команд, введите - Help");
        System.out.println("Чтобы создать новую заметку, введите - New ");
        System.out.println("Чтобы вывести список заметок, введите - List ");

        while (true) {

            //старт ворк луп

            String message = console.next();
            if (message.equalsIgnoreCase("End")) {
                System.out.println("Приложение завершило работу");
                break;
            }
            if (message.equalsIgnoreCase("New")) {
                Scanner localScanner = new Scanner(System.in);
                System.out.println("Введите заголок новой заметки: ");
                String title = localScanner.nextLine();
                System.out.println("Введите текст новой заметки: ");
                String text = localScanner.nextLine();
                jdbc.createNote(title, text);
                System.out.println("Заметка сохранена");
            }

            if (message.equalsIgnoreCase("Del")) {
                Scanner localScanner = new Scanner(System.in);
                System.out.println("Введите заголовок заметки, которую нужно удалить: ");
                jdbc.deleteNoteByTitle(localScanner.nextLine());
                System.out.println("Запись с заголовком удалена");
            }

            if (message.equalsIgnoreCase("All")) {
                jdbc.printAllNotes();
            }

            if (message.equalsIgnoreCase("List")) {
                System.out.println("Список заметок: ");
                jdbc.printList();
            }

            if (message.equalsIgnoreCase("Open")) {
                Scanner localScanner = new Scanner(System.in);
                System.out.println("Введите заголовок заметки, которую хотите открыть: ");
                jdbc.openNoteByTitle(localScanner.nextLine());
            }

            if (message.equalsIgnoreCase("Edit")) {
                Scanner localScanner = new Scanner(System.in);
                System.out.println("Введите заголовок заметки, которую хотите отредактировать: ");
                String oldTitle = localScanner.nextLine();
                System.out.println("Введите новый заголовок: ");
                String newTitle = localScanner.nextLine();
                System.out.println("Введите новый текст: ");
                String text = localScanner.nextLine();
                jdbc.editNoteByTitle(oldTitle, newTitle, text);
            }

            if (message.equalsIgnoreCase("Help")) {
                commands.printCommands();
            }
        }
    }
}






