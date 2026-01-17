package frontend.primary;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import tech.cpstudio.backend.student.Student;

public class StudentPanel {
    public VBox studentPanelLayout;
    public HBox InfoLayout;
    public Label nameLabel;
    public Button editButton;
    public HBox scoreTagLayout;
    public ScoreTag positiveTag;
    public ScoreTag negativeTag;

    public StudentPanel(Student student) {
        nameLabel = new Label(student.getMetadata().getId() + " " + student.getMetadata().getName());
        positiveTag = new ScoreTag(ScoreTagType.POSITIVE, student.getRecords().getPositive());
        negativeTag = new ScoreTag(ScoreTagType.NEGATIVE, student.getRecords().getNegative());
        editButton = new Button("Edit");
        InfoLayout = new HBox(nameLabel, editButton);
        scoreTagLayout = new HBox(positiveTag, negativeTag);
        studentPanelLayout = new VBox(InfoLayout, scoreTagLayout);
    }
}
