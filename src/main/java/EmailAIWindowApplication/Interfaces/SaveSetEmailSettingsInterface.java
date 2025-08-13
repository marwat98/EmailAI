package EmailAIWindowApplication.Interfaces;

import EmailAIWindowApplication.Alert.AlertClass;
import EmailAIWindowApplication.RefreshWindow.RefreshWindow;
import javafx.scene.control.TextField;

public interface SaveSetEmailSettingsInterface {
    void save(TextField fromSetEmail, TextField title, AlertClass alert, RefreshWindow refresh);
}
