package frontend;

import io.github.palexdev.materialfx.MFXResourcesLoader;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.mfxresources.fonts.MFXFontIcon;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImmersingScore extends Application {
    @Override
    public void start(Stage primaryStage) {
        // ===== 1. 初始化MaterialFX 必须放在第一行 =====
        MFXResourcesLoader.load(ImmersingScore.class);

        // ===== 2. 创建MaterialFX的核心控件 =====
        // MaterialFX输入框 (替代原生TextField)
        MFXTextField mfxTextField = new MFXTextField();
        mfxTextField.setPromptText("请输入内容 (MaterialFX输入框)");
        mfxTextField.setPrefWidth(300);

        // MaterialFX下拉框 (替代原生ComboBox)
        ObservableList<String> options = FXCollections.observableArrayList("Java", "JavaFX", "MaterialFX", "SpringBoot");
        MFXComboBox<String> mfxComboBox = new MFXComboBox<>(options);
        mfxComboBox.setPromptText("请选择 (MaterialFX下拉框)");
        mfxComboBox.setPrefWidth(300);

        // MaterialFX按钮 (替代原生Button)
        MFXButton mfxButton = new MFXButton("MaterialFX 按钮 点击我");
        mfxButton.setPrefWidth(300);
        // 按钮点击事件（和原生JavaFX完全一致）
        mfxButton.setOnAction(event -> {
            String text = mfxTextField.getText();
            String select = mfxComboBox.getValue();
            System.out.println("输入内容：" + text + " | 选择项：" + select);
        });

        // ===== 3. 布局容器 + 场景 + 舞台 =====
        VBox root = new VBox(20); // 垂直布局，控件间距20
        root.setStyle("-fx-padding: 30;"); // 内边距30
        root.getChildren().addAll(mfxTextField, mfxComboBox, mfxButton);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("MaterialFX 纯Java编码示例");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
