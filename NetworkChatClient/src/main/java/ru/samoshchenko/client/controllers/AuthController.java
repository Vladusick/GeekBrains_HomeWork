package ru.samoshchenko.client.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ru.samoshchenko.client.ClientChat;
import ru.samoshchenko.client.dialogs.Dialogs;
import ru.samoshchenko.client.model.Network;
import ru.samoshchenko.client.model.ReadCommandListener;
import ru.samoshchenko.clientserver.Command;
import ru.samoshchenko.clientserver.CommandType;
import ru.samoshchenko.clientserver.commands.AuthOkCommandData;
import ru.samoshchenko.clientserver.commands.ErrorCommandData;

import java.io.IOException;

public class AuthController {

   // public static final String AUTH_COMMAND = "/auth";
   //  public static final String AUTH_OK_COMMAND = "/authOK";

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button authButton;

    private ReadCommandListener readCommandListener;

    @FXML
    public void executeAuth(ActionEvent actionEvent) {
        String login = loginField.getText();
        String password = passwordField.getText();

        if (login == null || login.isBlank() || password == null || password.isBlank()) {
            Dialogs.AuthError.EMPTY_CREDENTIALS.show();
            return;
        }

        if (!connectToServer()) {
            Dialogs.NetworkError.SERVER_CONNECT.show();
        }

        try {
            Network.getInstance().sendAuthMessage(login, password);
        } catch (IOException e) {
            Dialogs.NetworkError.SEND_MESSAGE.show();
            e.printStackTrace();
        }
    }

    private boolean connectToServer() {
        Network network = Network.getInstance();
        return network.isConnected() || network.connect();
    }

    public void initializeMessageHandler() {
        readCommandListener = getNetwork().addReadMessageListener(new ReadCommandListener() {
            @Override
            public void processReceivedCommand(Command command) {
                if (command.getType() == CommandType.AUTH_OK) {
                    AuthOkCommandData data = (AuthOkCommandData) command.getData();
                    String userName = data.getUsername();
                    Network.getInstance().setCurrentUserName(userName);
                    Platform.runLater(() -> {
                        ClientChat.INSTANCE.switchToMainChatWindow(userName);
                    });
                } else if (command.getType() == CommandType.ERROR) {
                    ErrorCommandData data = (ErrorCommandData) command.getData();
                    String errorMessage = data.getErrorMessage();
                    Platform.runLater(() -> {
                        Dialogs.AuthError.INVALID_CREDENTIALS.show(errorMessage);
                    });
                }
            }

        });
    }

    public void close() {
        getNetwork().removeReadMessageListener(readCommandListener);
    }

    private Network getNetwork() {
        return Network.getInstance();
    }
}
