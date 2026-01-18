package frontend.primary;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import tech.cpstudio.backend.class_.Class;

import java.util.ArrayList;
import java.util.List;

public class ClassSwitcherDialog extends Dialog<Class> {
    public ClassSwitcherDialog(Class currentClass) {
        super();
        setTitle("Switch Class");
        setHeaderText("Switch Class");

        VBox layout = new VBox(10);
        ToggleGroup group = new ToggleGroup();

        List<RadioButton> classes = new ArrayList<>();
        classes.add(new RadioButton("Class 1"));
        classes.add(new RadioButton("Class 2"));
        classes.add(new RadioButton("Class 3"));
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
                return null; // TODO: Return selected class
            } else {
                return null;
            }
        });
    }
}
