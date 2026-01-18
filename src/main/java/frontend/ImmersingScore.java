package frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ImmersingScore extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/primary/PrimaryWindow.fxml"));
        BorderPane root = loader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Immersing Score");
        primaryStage.show();
    }
}
