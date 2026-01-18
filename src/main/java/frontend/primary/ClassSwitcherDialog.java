package frontend.primary;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import tech.cpstudio.backend.class_.Class;
import tech.cpstudio.backend.class_.ClassManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 按下切换班级按钮时弹出的对话框
 */
public class ClassSwitcherDialog extends Dialog<Class> {
    public ClassSwitcherDialog(Class currentClass) {
        super();
        setTitle("Switch Class");
        setHeaderText("Switch Class");

        VBox layout = new VBox(10);
        ToggleGroup group = new ToggleGroup();

        List<RadioButton> classes = new ArrayList<>();

        for (Class class_ : ClassManager.INSTANCE.getClasses()) {
            classes.add(new RadioButton(class_.getName()));
        }

        for (RadioButton button : classes) {
            button.setToggleGroup(group);
            if (button.getText().equals(currentClass.getName())) {
                button.setSelected(true);
            }
        }
        layout.getChildren().addAll(classes);

        getDialogPane().setContent(layout);
        getDialogPane().getButtonTypes().addAll(javafx.scene.control.ButtonType.OK, javafx.scene.control.ButtonType.CANCEL);
        setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                Toggle selected = group.getSelectedToggle();
                if (selected != null) {
                    RadioButton selectedButton = (RadioButton) selected;
                    Class class_ = ClassManager.INSTANCE.findClass(selectedButton.getText());
                    if (class_ != null) {
                        return class_;
                    } else {
                        throw new RuntimeException("ber，班怎么解散了");
                    }
                }
            }
            return null;
        });
    }
}
