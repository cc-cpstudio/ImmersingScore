package frontend;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ImmersingScore extends Application {
    private ToolBar toolBarBuilder() {
        ToolBar toolBar = new ToolBar();

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Example1", "Example2", "Example3");
        comboBox.setValue("Example1");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label label = new Label("Hello world!");

        Button button = new Button("Click me!");

        toolBar.getItems().addAll(comboBox, spacer, label, button);

        return toolBar;
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setBottom(toolBarBuilder());

        primaryStage.setScene(new javafx.scene.Scene(root, 800, 600));
        primaryStage.show();
    }
}
