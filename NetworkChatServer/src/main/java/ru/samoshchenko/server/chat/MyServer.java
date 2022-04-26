package ru.samoshchenko.server.chat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.samoshchenko.clientserver.Command;
import ru.samoshchenko.server.chat.auth.AuthService;
import ru.samoshchenko.server.chat.auth.IAuthService;
import ru.samoshchenko.server.chat.auth.PersistentDbAuthService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServer {

    private final List<ClientHandler> clients = new ArrayList<>();
    private IAuthService authService;
    private ExecutorService executorService;
    private static final Logger log = LogManager.getLogger(MyServer.class);

    public IAuthService getAuthService() {
        return authService;
    }


    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
          //  System.out.println("Server has been started");
            log.info("Server has been started");
            authService = createAuthService();
            authService.start();
            executorService = Executors.newCachedThreadPool();
            while (true) {
                waitAndProcessClientConnection(serverSocket);
            }

        } catch (IOException e) {
          //  System.err.println("Failed to bind port " + port);
            log.info("Failed to bind port " + port);
            e.printStackTrace();
        } finally {
           if (authService != null) {
               authService.stop();
           }
           if (executorService != null) {
               executorService.shutdown();
           }
        }
    }

    private IAuthService createAuthService() {
        // переключение старой и новой реализации
        // return new AuthService();
        return new PersistentDbAuthService();
    }


    private void waitAndProcessClientConnection(ServerSocket serverSocket) throws IOException {
      //  System.out.println("Waiting for new client connection");
        log.info("Waiting for new client connection");
        Socket clientSocket = serverSocket.accept();
    //    System.out.println("Client has been connected");
        log.info("Client has been connected");
        ClientHandler clientHandler = new ClientHandler(this, clientSocket);
        clientHandler.handle();
    }

    public synchronized void broadcastMessage(String message, ClientHandler sender) throws IOException {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendCommand(Command.clientMessageCommand(sender.getUsername(), message));
            }
        }
    }

    public synchronized void sendPrivateMessage(ClientHandler sender, String recipient, String privateMessage) throws IOException {
        for (ClientHandler client : clients) {
            if (client != sender && client.getUsername().equals(recipient)) {
                client.sendCommand(Command.clientMessageCommand(sender.getUsername(), privateMessage));
            }
        }
    }

    public synchronized boolean isUsernameBusy(String username) {
        for (ClientHandler client : clients) {
            if (client.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void subscribe(ClientHandler clientHandler) throws IOException {
        clients.add(clientHandler);
        notifyClientUserListUpdated();
    }

    public synchronized void unsubscribe(ClientHandler clientHandler) throws IOException {
        clients.remove(clientHandler);
        notifyClientUserListUpdated();
    }



    public void notifyClientUserListUpdated() throws IOException {
        List<String> userListOnline = new ArrayList<>();

        for (ClientHandler client : clients) {
            userListOnline.add(client.getUsername());
        }
        for (ClientHandler client : clients) {
            client.sendCommand(Command.updateUserListCommand(userListOnline));
        }
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }
}


