package Settings;

import Alert.AlertClass;
import FileManagerClasses.FileManagerOpenAIClass;
import Interfaces.SaveSettingsInterface;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static SetEmail.SetEmail.MAIN_PACKAGE_FILES;

public class SaveSettings implements SaveSettingsInterface {

    private static final Path HOST_ADDRESS = Paths.get(MAIN_PACKAGE_FILES,"hostAddress.txt");
    private static final Path POST_OFFICE = Paths.get(MAIN_PACKAGE_FILES,"postOfficeChoose.txt");
    private static final Path POST_PASSWORD = Paths.get(MAIN_PACKAGE_FILES,"postPassword.txt");
    private static final Path PLACE_OF_CHOICE = Paths.get(MAIN_PACKAGE_FILES,"searchPoleDirection.txt");
    private static final Path API_PATH = Paths.get(MAIN_PACKAGE_FILES , "APIKEY.txt");

    public File apiFile = new File(String.valueOf(API_PATH));
    public File hostAddressFile = new File(String.valueOf(HOST_ADDRESS));
    public File postPasswordFile = new File(String.valueOf(POST_PASSWORD));
    public File placeOfChoiceFile = new File(String.valueOf(PLACE_OF_CHOICE));

    public FileManagerOpenAIClass apiKeySave = new FileManagerOpenAIClass(apiFile.toPath());
    public FileManagerOpenAIClass postOfficeOption = new FileManagerOpenAIClass(POST_OFFICE);
    public FileManagerOpenAIClass hostAddressSave = new FileManagerOpenAIClass(hostAddressFile.toPath());
    public FileManagerOpenAIClass postPasswordSave = new FileManagerOpenAIClass(postPasswordFile.toPath());
    public FileManagerOpenAIClass placeOfChoiceSave = new FileManagerOpenAIClass(placeOfChoiceFile.toPath());


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


        boolean saveAPIKey = apiKeySave.writeToFile(settingsField.getCheckAPIKey());
        boolean saveChoosePostOfficeOption = postOfficeOption.writeToFile(settingsField.getCheckHostAddress());
        boolean saveHostAdress = hostAddressSave.writeToFile(settingsField.getCheckPostPassword());
        boolean savePostPassword = postPasswordSave.writeToFile(settingsField.getCheckPostPassword());
        boolean savePlaceOfChoice = placeOfChoiceSave.writeToFile(settingsField.getCheckPlaceOfChoice());

        if(saveAPIKey && saveChoosePostOfficeOption && saveHostAdress && savePostPassword && savePlaceOfChoice){
            alert.alertMessage("Succes","✅ Settings are saving");
        }
    }
}
