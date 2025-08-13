package EmailAIWindowAplication.Interfaces;

import EmailAIWindowAplication.Alert.AlertClass;
import EmailAIWindowAplication.RefreshWindow.RefreshWindow;
import javafx.scene.control.TextInputControl;

public interface GenerateInterface {
    void generateOpenAI(TextInputControl textInputControl, AlertClass alert, RefreshWindow refresh);
}
