package jdbc;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner commandInputScanner = new Scanner(System.in);
        Scanner queryInputScanner = new Scanner(System.in);
        JDBC jdbc = new JDBC();
        CommandService commandService = new CommandService();

        System.out.println(Commands.START_MSG.getText());
        System.out.println(" - - - ");
        System.out.println(Commands.START_MSG_HELP.getText());
        System.out.println(Commands.START_MSG_NEW.getText());
        System.out.println(Commands.START_MSG_LIST.getText());

        while (true) {

            String message = commandInputScanner.nextLine();
            switch (message) {

                case "End" -> {
                    System.out.println(Commands.APP_OFF_MSG.getText());
                    System.exit(0);
                }

                case "New" -> {
                    System.out.println(Commands.NEW_NOTE_TITLE_MSG.getText());
                    String title = queryInputScanner.nextLine();
                    System.out.println(Commands.NEW_NOTE_TEXT_MSG.getText());
                    String text = queryInputScanner.nextLine();
                    jdbc.createNote(title, text);
                    System.out.println(Commands.NOTE_SAVED_MSG.getText());
                }

                case "Del" -> {
                    System.out.println(Commands.DEL_MSG.getText());
                    System.out.println(jdbc.deleteNoteByTitle(queryInputScanner.nextLine()));
                }

                case "All" -> {
                    jdbc.printAllNotes();
                }

                case "List" -> {
                    System.out.println("Список заметок: ");
                    jdbc.printList();
                }

                case "Open" -> {
                    System.out.println("Введите заголовок заметки, которую хотите открыть: ");
                    jdbc.openNoteByTitle(queryInputScanner.nextLine());
                }

                case "Edit" -> {
                    System.out.println("Введите заголовок заметки, которую хотите отредактировать: ");
                    String oldTitle = queryInputScanner.nextLine();
                    if (jdbc.checkQueryByTitle(oldTitle)) {
                        System.out.println("Введите новый заголовок: ");
                        String newTitle = queryInputScanner.nextLine();
                        System.out.println("Введите новый текст: ");
                        String text = queryInputScanner.nextLine();
                        jdbc.editNoteByTitle(oldTitle, newTitle, text);
                    } else System.out.println("Заметка с таким заголовком не найдена");
                }

                case "Help" -> {
                    commandService.printCommands();
                }

                default -> {
                    System.out.println("Такой команды не существует. Чтобы получить список команд введите - Help");
                }

                /*
            }
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
                commandService.printCommands();


                 */
            }
        }
    }
}






