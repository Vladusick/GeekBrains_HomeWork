package q2Lesson6.client;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientChat extends Application {

    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 8189;
    public static final String CONNECTION_ERROR_MESSAGE = "Невозможно установить сетевое соединение";

    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("chat-template.fxml"));

        Parent load = fxmlLoader.load();
        Scene scene = new Scene(load);

        this.stage.setTitle("Онлайн чат GeekBrains");
        this.stage.setScene(scene);

        ClientController controller = fxmlLoader.getController();
        controller.userList.getItems().addAll("user1", "user2");

        stage.show();
        connectToServer(controller);

    }

    private void connectToServer(ClientController clientController) {

        Network network = new Network();
        boolean result = network.connect();

        if (!result) {
            String errorMessage = CONNECTION_ERROR_MESSAGE;
            System.err.println(errorMessage);
            showErrorDialog(errorMessage);
            return;
        }

        clientController.setNetwork(network);
        clientController.setApplication(this);

        this.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                network.close();
            }
        });
    }

    private void setOnCloseRequest() {

    }

    public void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}