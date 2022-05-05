package jdbc;

import java.util.Objects;


// ЭТОТ КЛАСС СЕЙЧАС НЕ ИСПОЛЬЗУЕТСЯ
public class NoteBase {

    private final int id;
    private final String title;
    private final String text;

    public NoteBase(int id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteBase noteBase = (NoteBase) o;
        return id == noteBase.id && Objects.equals(title, noteBase.title) && Objects.equals(text, noteBase.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, text);
    }

    @Override
    public String toString() {
        return "NoteBase{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
