package frontend.tools;

import javafx.scene.image.Image;

/**
 * 工具基类，为后续工具和插件提供基础框架
 * @author cc-cpstudio
 */
public abstract class ToolBase {
    public String name;
    public Image icon;

    public abstract void action();
}
