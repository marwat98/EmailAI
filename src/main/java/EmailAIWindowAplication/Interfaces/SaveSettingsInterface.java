package EmailAIWindowAplication.Interfaces;

import EmailAIWindowAplication.Alert.AlertClass;
import EmailAIWindowAplication.Settings.SettingsField;

public interface SaveSettingsInterface {
     void saveSettings(SettingsField settingsField, AlertClass alert);
}
