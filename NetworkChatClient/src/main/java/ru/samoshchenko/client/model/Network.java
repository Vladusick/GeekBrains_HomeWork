package ru.samoshchenko.client.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.http.WebSocket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

public class Network {

    private List<ReadMessageListener> listeners = new CopyOnWriteArrayList<>();

    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 8189;

    private int port;
    private String host;
    private Socket socket;
    private DataInputStream socketInput;
    private DataOutputStream socketOutput;

    private static Network INSTANCE;
    private Thread readMessageProcess;
    private boolean connected;

    public static Network getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Network();
        }
        return INSTANCE;
    }

    private Network(int port, String host) {
        this.port = port;
        this.host = host;
    }

    private Network() {
        this(SERVER_PORT, SERVER_HOST);
    }

    public boolean connect() {
        try {
            this.socket = new Socket(this.host, this.port);
            this.socketInput = new DataInputStream(socket.getInputStream());
            this.socketOutput = new DataOutputStream(socket.getOutputStream());
            readMessageProcess = startReadMessageProcess();
            connected = true;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Не удалось установить соединение");
            return false;
        }
    }

    public void sendMessage(String message) throws IOException {
        try {
            socketOutput.writeUTF(message);
        } catch (IOException e) {
            System.err.println("Не удалось отправить сообщение на сервер");
            throw e;
        }
    }

    public Thread startReadMessageProcess() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }
                    String message = socketInput.readUTF();

                    for (ReadMessageListener messageListener : listeners) {
                        messageListener.processReceivedMessage(message);
                    }

                } catch (IOException e) {
                    System.err.println("Не удалось прочитать сообщение от сервера");
                    close();
                    break;
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        return thread;
    }

    public ReadMessageListener addReadMessageListener(ReadMessageListener listener) {
        listeners.add(listener);
        return listener;
    }

    public void removeReadMessageListener(ReadMessageListener listener) {
        listeners.remove(listener);
    }

    public void close() {
        try {
            connected = false;
            readMessageProcess.interrupt();
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        return connected;
    }
}


