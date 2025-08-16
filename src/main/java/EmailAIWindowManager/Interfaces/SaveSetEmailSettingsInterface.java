package EmailAIWindowManager.Interfaces;

import EmailAIWindowManager.Alert.AlertClass;
import EmailAIWindowManager.RefreshWindow.RefreshWindow;
import javafx.scene.control.TextField;

public interface SaveSetEmailSettingsInterface {
    void save(TextField fromSetEmail, TextField title, AlertClass alert, RefreshWindow refresh);
}
