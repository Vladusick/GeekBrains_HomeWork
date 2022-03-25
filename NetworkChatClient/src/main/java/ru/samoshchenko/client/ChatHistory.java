package ru.samoshchenko.client;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ChatHistory implements AutoCloseable {

    private static final String FILENAME_PATTERN = "./history/history_%s.txt";

    private final String username;
    private File historyFile;
    private PrintWriter printWriter;

    public ChatHistory(String username) {
        this.username = username;
    }

    public void init() {
        try {
            historyFile = createHistoryFile();
            this.printWriter = new PrintWriter(new BufferedWriter(new FileWriter(historyFile, StandardCharsets.UTF_8, true)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File createHistoryFile() throws IOException {
        String filePath = String.format(FILENAME_PATTERN, username);
        File file = new File(filePath);
        if (!file.exists()) {
            file.getParentFile().mkdir();
            file.createNewFile();
        }
        return file;
    }

    public void appendText(String text) {
        printWriter.print(text);
        printWriter.flush();
    }

    @Override
    public void close() {
        if (printWriter != null) {
            printWriter.close();
        }
    }
}
