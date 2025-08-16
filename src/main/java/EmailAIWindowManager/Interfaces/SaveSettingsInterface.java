package EmailAIWindowManager.Interfaces;

import EmailAIWindowManager.Alert.AlertClass;
import EmailAIWindowManager.Settings.SettingsField;

public interface SaveSettingsInterface {
     void saveSettings(SettingsField settingsField, AlertClass alert);
}
