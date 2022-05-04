package jdbc;

public enum Commands {


    START_MSG("Вас приветствует консольное приложение - СПИСОК ЗАМЕТОК"),
    START_MSG_HELP("Чтобы получить список всех команд, введите - Help"),
    START_MSG_NEW("Чтобы создать новую заметку, введите - New "),
    START_MSG_LIST("Чтобы вывести список заметок, введите - List "),

    LIST_OF_COMMANDS("Список команд: "),
    NEW("New - создать новую заметку"),
    LIST("List - вывести список заметок"),
    ALL("All - вывести все заметки"),
    OPEN("Open - открыть заметку"),
    DEL("Del - удалить заметку"),
    EDIT("Edit - редактировать заметку"),
    END("End - завершить работу приложения"),
    HELP("Help - получить список команд"),

    APP_OFF_MSG("Работа приложения завершена"),
    NEW_NOTE_TITLE_MSG("Введите заголовок новой заметки: "),
    NEW_NOTE_TEXT_MSG("Введите текст новой заметки: "),
    NOTE_SAVED_MSG("Заметка сохранена"),
    DEL_MSG("Введите заголовок заметки, которую нужно удалить: ");




    private String text;

    public String getText() {
        return text;
    }

    Commands(String text) {
        this.text = text;


    }
}
