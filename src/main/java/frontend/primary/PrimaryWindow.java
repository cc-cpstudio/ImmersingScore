package frontend.primary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import tech.cpstudio.backend.class_.Class;
import tech.cpstudio.backend.student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 主窗口控制器，用于实现主窗口的逻辑和FXML文件联动
 */
public class PrimaryWindow {
    Class currentClass;

    List<StudentPanel> studentPanels = new ArrayList<>();

    @FXML
    public FlowPane studentPane;
    @FXML
    public Label currentClassLabel;

    public PrimaryWindow() {
        
    }

    @FXML
    public void switchClicked(ActionEvent actionEvent) {
        ClassSwitcherDialog newClass = new ClassSwitcherDialog(currentClass);
        Optional<Class> result = newClass.showAndWait();
        result.ifPresent(aClass -> {
            currentClass = aClass;
        });
    }

    @FXML
    public void editClicked(ActionEvent actionEvent) {

    }

    @FXML
    public void filterClicked(ActionEvent actionEvent) {

    }

    @FXML
    public void minimizeClicked(ActionEvent actionEvent) {

    }

    @FXML
    public void toolsClicked(ActionEvent actionEvent) {

    }

    @FXML
    public void rankingClicked(ActionEvent actionEvent) {

    }

    public void refresh() {
        if (studentPane != null) {
            studentPane.getChildren().clear();
        } else {
            studentPane = new FlowPane();
        }
        for (Student student : currentClass.getStudents()) {
            studentPanels.add(new StudentPanel(student));
        }
    }
}
