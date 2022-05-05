package jdbc;

import java.util.ArrayList;
import java.util.List;

// ЭТОТ КЛАСС СЕЙЧАС НЕ ИСПОЛЬЗУЕТСЯ
public class NoteServiceBase {

    private List<NoteBase> listNotes = new ArrayList<>();

    public void print() {
        System.out.println("список задачь полный");
        System.out.println(listNotes);
    }

    public void printText() {
        System.out.println("Список заметок: ");
        for (NoteBase listNote : listNotes) {
            System.out.println(listNote.getText());
        }
    }

    public void printTitle() {
        System.out.println("Список заголовков: ");
        for (NoteBase listNote : listNotes) {
            System.out.println(listNote.getTitle());
        }
    }

    public void truePrint() {
        for (NoteBase listNote : listNotes) {
            System.out.println("Заметка: " + listNote.getTitle());
            System.out.println("Текст заметки: " + listNote.getText());
        }
    }

    public void addNote(NoteBase note) {
        listNotes.add(note);
    }


    public void openNote(String message) {
        for (NoteBase listNote : listNotes) {
            if (message.equalsIgnoreCase(listNote.getTitle())) {

                System.out.println("Текс заметки " + listNote.getTitle() + " : " + listNote.getText());
            }
        }
    }
}

