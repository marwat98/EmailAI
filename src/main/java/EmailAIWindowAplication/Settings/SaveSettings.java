package EmailAIWindowAplication.Settings;

import EmailAIWindowAplication.Alert.AlertClass;
import EmailAIWindowAplication.FileResources.FileRecources;
import EmailAIWindowAplication.Interfaces.SaveSettingsInterface;


public class SaveSettings implements SaveSettingsInterface {

    // class where are paths , files , objects to serve methods
    FileRecources fileRecources = new FileRecources();

    /**
     * method which save settings to files
     * @param settingsField class which implements getters of field
     * @param alert class which return message alert
     */
    @Override
    public void saveSettings(SettingsField settingsField, AlertClass alert) {

        if(settingsField.getCheckAPIKey().isEmpty()){
            alert.alertMessage("Empty field!", "❌ Your API Key field is empty");
            return;
        }
        if(settingsField.getCheckHostAddress().isEmpty()){
            alert.alertMessage("Empty field!", "❌ Your Host Adress field is empty");
            return;
        }
        if(settingsField.getCheckPostPassword().isEmpty()){
            alert.alertMessage("Empty field!", "❌ Your Post Password field is empty");
            return;
        }
        if(settingsField.getCheckPlaceOfChoice().isEmpty()){
            alert.alertMessage("Empty field!", "❌ Your Place of choice field is empty");
            return;
        }

        boolean saveAPIKey = fileRecources.apiKeySave.writeToFile(settingsField.getCheckAPIKey());
        boolean saveChoosePostOfficeOption = fileRecources.postOfficeOption.writeToFile(settingsField.getCheckHostAddress());
        boolean saveHostAdress = fileRecources.hostAddressSave.writeToFile(settingsField.getCheckPostPassword());
        boolean savePostPassword = fileRecources.postPasswordSave.writeToFile(settingsField.getCheckPostPassword());
        boolean savePlaceOfChoice = fileRecources.placeOfChoiceSave.writeToFile(settingsField.getCheckPlaceOfChoice());

        if(saveAPIKey && saveChoosePostOfficeOption && saveHostAdress && savePostPassword && savePlaceOfChoice){
            alert.alertMessage("Succes","✅ Settings are saving");
        }
    }
}
