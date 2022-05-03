package jdbc;

import java.sql.*;

public class JDBC {

    public static final String DB_URL = "jdbc:sqlite:C:/Users/Vladislav/IdeaProjects/GeekBrains_HomeWork/notes";

    public static void main(String[] args) {
        JDBC jdbc = new JDBC();
    }

    public void printAllNotes() {

        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            Statement statement = connection.createStatement();

            //удалене данных
            // statement.executeUpdate("delete from notes where id = 3");

            //добавление данных
            //  statement.executeUpdate("insert into notes (title, text) values ('Купить хлеб', 'в магазине магнит булку белого')");

            //вывод данных
            ResultSet resultSet = statement.executeQuery("SELECT * FROM notes");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String text = resultSet.getString("text");
                System.out.printf("Номер заметки: %d%n Заголок заметки: %s%n Текст заметки: %s%n - - - %n", id, title, text);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printList() {

        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT title FROM notes");

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                System.out.println("- " + title);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createNote(String title, String text) {

        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            Statement statement = connection.createStatement();

            String sql = String.format("INSERT INTO notes (title, text) VALUES ('%s', '%s')", title, text);
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // работает криво если нет записи все равно убдет писать что запись удалена
    public void deleteNoteByTitle(String title) {

        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            Statement statement = connection.createStatement();

            String sql = String.format("DELETE FROM notes WHERE title = '%s'", title);
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void openNoteByTitle(String titleValue) {

        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            Statement statement = connection.createStatement();

            String sql = String.format("SELECT text FROM notes WHERE title = '%s'", titleValue);
            statement.executeQuery(sql);

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String text = resultSet.getString("text");
                System.out.println("Текст заметки: " + text);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editNoteByTitle(String oldTitle, String newTitle, String text) {

        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            Statement statement = connection.createStatement();

            String sql = String.format("UPDATE notes SET title = '%s', text = '%s' WHERE title = '%s';", newTitle, text, oldTitle);
            statement.executeUpdate(sql);
            System.out.println("Заметка изменена");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


//   UPDATE notes SET title = 'privet', text = 'update' WHERE title = 'Дядя тольда';

//удалене данных
// statement.executeUpdate("delete from notes where id = 3");

//добавление данных
//  statement.executeUpdate("insert into notes (title, text) values ('Купить хлеб', 'в магазине магнит булку белого')");

//вывод данных


