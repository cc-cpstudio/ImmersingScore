package frontend.tools;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

/**
 * 工具集窗口控制器
 * @author cc-cpstudio
 */
public class ToolWindow {
    @FXML
    public GridPane gridPane;

    public void initialize() {
        gridPane.getChildren().clear();
    }
}
