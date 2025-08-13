package EmailAIWindowApplication.Interfaces;

import EmailAIWindowApplication.Alert.AlertClass;
import EmailAIWindowApplication.Settings.SettingsField;

public interface SaveSettingsInterface {
     void saveSettings(SettingsField settingsField, AlertClass alert);
}
