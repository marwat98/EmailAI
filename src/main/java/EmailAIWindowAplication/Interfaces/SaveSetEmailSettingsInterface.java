package EmailAIWindowAplication.Interfaces;

import EmailAIWindowAplication.Alert.AlertClass;
import EmailAIWindowAplication.RefreshWindow.RefreshWindow;
import javafx.scene.control.TextField;

public interface SaveSetEmailSettingsInterface {
    void save(TextField fromSetEmail, TextField title, AlertClass alert, RefreshWindow refresh);
}
