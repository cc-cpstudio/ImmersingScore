package frontend.primary;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class PrimaryWindow {
    public FlowPane studentsPane;
    public BorderPane borderPane;
    public ToolBar toolBar;
    public ComboBox<String> classSelectorComboBox;

    public void builder(Pane root) {
        toolBar = new ToolBar();

    }
}
