package EmailAIWindowManager.Interfaces;

import EmailAIWindowManager.Alert.AlertClass;
import EmailAIWindowManager.RefreshWindow.RefreshWindow;
import javafx.scene.control.TextInputControl;

public interface GenerateInterface {
    void generateOpenAI(TextInputControl textInputControl, AlertClass alert, RefreshWindow refresh);
}
