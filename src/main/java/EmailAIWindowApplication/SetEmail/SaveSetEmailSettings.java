package EmailAIWindowApplication.SetEmail;

import EmailAIWindowApplication.FileManagerClasses.FileManagerClass;
import EmailAIWindowApplication.FileManagerClasses.FileManagerOpenAIClass;
import EmailAIWindowApplication.FileResources.FileRecources;
import EmailAIWindowApplication.Interfaces.SaveSetEmailSettingsInterface;
import EmailAIWindowApplication.RefreshWindow.RefreshWindow;
import javafx.scene.control.TextField;
import EmailAIWindowApplication.Alert.AlertClass;


import static EmailAIWindowApplication.FileResources.FileRecources.FROM_PATH;
import static EmailAIWindowApplication.FileResources.FileRecources.TITLE_PATH;


public class SaveSetEmailSettings implements SaveSetEmailSettingsInterface {

    // class where are paths , files , objects to serve methods
    FileRecources fileRecourcesSaveSetEmail = new FileRecources();

    /**
     *
     * @param fromSetEmail field which set your email
     * @param title field which set title your email
     * @param alert method that show alerts
     * @param refresh method that refresh pole after saving settings
     */
    @Override
    public void save(TextField fromSetEmail, TextField title, AlertClass alert, RefreshWindow refresh) {

        try{
            FileManagerClass fileSetYourEmailClass = new FileManagerClass(fileRecourcesSaveSetEmail.myEmailFile.toPath());
            FileManagerOpenAIClass saveTitleOpenAI = new FileManagerOpenAIClass(fileRecourcesSaveSetEmail.titleFile.toPath());

            boolean fromSaveToFile = fileSetYourEmailClass.writeToFile(fromSetEmail.getText());
            boolean toSaveTitleToFile = saveTitleOpenAI.writeToFile(title.getText());

            if(fromSaveToFile){
                alert.alertMessage("Success", "✅ You save email");
                refresh.refreshWindow(fromSetEmail,FROM_PATH);
            } else {
                alert.alertMessage("Fail!","❌ Saving email in file failing");
                return;
            }

            if (toSaveTitleToFile) {
                alert.alertMessage("Success", "✅ You save title");
                refresh.refreshWindow(title,TITLE_PATH);
            } else {
                alert.alertMessage("Fail!","❌ Saving title in file failing");
            }
        } catch (Exception e) {
            alert.alertMessage("File Error", "Could not read or write the file: " + e.getMessage());
        }
    }
}
