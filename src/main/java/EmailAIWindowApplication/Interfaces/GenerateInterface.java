package EmailAIWindowApplication.Interfaces;

import EmailAIWindowApplication.Alert.AlertClass;
import EmailAIWindowApplication.RefreshWindow.RefreshWindow;
import javafx.scene.control.TextInputControl;

public interface GenerateInterface {
    void generateOpenAI(TextInputControl textInputControl, AlertClass alert, RefreshWindow refresh);
}
