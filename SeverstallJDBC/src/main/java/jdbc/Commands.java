package jdbc;

import java.util.ArrayList;
import java.util.List;

public class Commands {

   public void printCommands() {
       List<String> commands = new ArrayList<>();

       commands.add("Список команд: ");
       commands.add("New - создать новую заметку");
       commands.add("List - вывести список заметок");
       commands.add("All - вывести все заметки");
       commands.add("Open - открыть заметку");
       commands.add("Del - удалить заметку");
       commands.add("Edit - редактировать заметку");
       commands.add("End - завершить работу приложения");
       commands.add("Help - получить список команд");

       for (String command : commands) {
           System.out.println(command);
       }
   }
}


