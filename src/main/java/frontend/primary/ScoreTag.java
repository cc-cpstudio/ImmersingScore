package frontend.primary;

import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * 等待注释
 */
public class ScoreTag extends Region {
    private final ScoreTagType type;
    private Integer score;
    private final Label textLabel = new Label();


    public ScoreTag(ScoreTagType type, Integer score) throws IllegalArgumentException {
        this.score = score;
        this.type = type;

        String displayText;
        if (type == ScoreTagType.POSITIVE) {
            displayText = "+" + score.toString();
        } else if (type == ScoreTagType.NEGATIVE) {
            displayText = "-" + score.toString();
        } else {
            throw new IllegalArgumentException("Invalid ScoreTagType");
        }
        textLabel.setText(displayText);

        initView();
    }


    private void initView() {
        getChildren().add(textLabel);

        textLabel.layoutXProperty().bind(this.widthProperty().subtract(textLabel.widthProperty()).divide(2));
        textLabel.layoutYProperty().bind(this.heightProperty().subtract(textLabel.heightProperty()).divide(2));

        this.setPrefSize(180, 60);
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        double halfHeight = getHeight() / 2;
        Rectangle rect = new Rectangle(getWidth() - halfHeight * 2, getHeight());
        Circle leftCircle = new Circle(halfHeight, halfHeight, halfHeight);
        Circle rightCircle = new Circle(getWidth() - halfHeight, halfHeight, halfHeight);
        Shape capsule = Shape.union(Shape.union(rect, leftCircle), rightCircle);

        switch (type) {
            case POSITIVE:
                capsule.setStroke(Color.web("#1F4DFF"));
                capsule.setFill(Color.web("#218CFF"));
            case NEGATIVE:
                capsule.setStroke(Color.web("#FF1F4D"));
                capsule.setFill(Color.web("#FF7162"));
        }

        capsule.setStrokeWidth(2);

        this.setShape(capsule);
    }

    public ScoreTagType getType() {
        return type;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
