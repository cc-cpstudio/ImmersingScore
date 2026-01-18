package frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ImmersingScore extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/frontend/primary/PrimaryWindow.fxml"));
        VBox root = loader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Immersing Score");
        primaryStage.show();
    }
}
