package frontend;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImmersingScore extends Application {
    @Override
    public void start(Stage primaryStage) {
        // 1. 创建界面控件
        Label helloLabel = new Label("Hello JavaFX! （Maven 项目）"); // 文本标签
        Button clickButton = new Button("点击我"); // 按钮

        // 给按钮添加点击事件
        clickButton.setOnAction(event -> helloLabel.setText("按钮已点击！"));

        // 2. 创建布局容器，摆放控件（VBox：垂直布局）
        VBox root = new VBox(10); // 10 是控件之间的间距
        root.getChildren().addAll(helloLabel, clickButton); // 添加控件到布局
        root.setStyle("-fx-alignment: center; -fx-padding: 20px;"); // 样式：居中+内边距

        // 3. 创建场景（Scene：包含布局和控件的容器）
        Scene scene = new Scene(root, 300, 200); // 宽300，高200

        // 4. 配置主窗口并展示
        primaryStage.setTitle("JavaFX Maven 入门 Demo"); // 窗口标题
        primaryStage.setScene(scene); // 将场景设置到主窗口
        primaryStage.setResizable(false); // 禁止窗口缩放
        primaryStage.show(); // 显示窗口
    }
}
