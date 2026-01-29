package frontend.editor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;

/**
 * 编辑窗口控制器，用于实现编辑窗口的逻辑和FXML文件联动
 */
public class EditorWindow {
    @FXML
    public StackPane contentContainer;
    public TabPane mainTabPane;

    @FXML
    public void switchToGeneral(ActionEvent actionEvent) {

    }

    @FXML
    public void switchToStudents(ActionEvent actionEvent) {

    }

    @FXML
    public void switchToRules(ActionEvent actionEvent) {

    }

    @FXML
    public void switchToSync(ActionEvent actionEvent) {

    }

    @FXML
    public void initialize() {
        mainTabPane.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, oldTab, newTab) -> {
                    if (newTab != null) {
                        String tabText = newTab.getText();
                        // TODO
                    }
                });
        mainTabPane.getSelectionModel().selectFirst();
    }
}
