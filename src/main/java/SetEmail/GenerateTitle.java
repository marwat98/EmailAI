package SetEmail;

import Alert.AlertClass;
import FileResources.FileRecources;
import Interfaces.GenerateInterface;
import OpenAIConfigurator.OpenAIConfigurator;
import RefreshWindow.RefreshWindow;
import javafx.scene.control.TextInputControl;

public class GenerateTitle implements GenerateInterface {

    // class where are paths , files , objects to serve methods
    FileRecources fileRecources = new FileRecources();
    // class which settings Open AI
    OpenAIConfigurator openAIConfigurator = new OpenAIConfigurator();

    /**
     *
     * @param title TextArea for show title
     * @param alert class which show alert
     * @param refresh class which refresh window after finish operation
     */
    @Override
    public void generateOpenAI(TextInputControl title, AlertClass alert, RefreshWindow refresh) {
        String apiKeyTitle = fileRecources.fileManagerTitleOpenAI.readFile(fileRecources.apiFile);
        try{
            // Variable which generate title using OpenAI
            String generateTitle  = openAIConfigurator.generate("Generate only one email title with greetings without description", apiKeyTitle);

            // Input which set generated title
            title.setText(generateTitle);

            // Variable which get title of input
            String input = title.getText();

            // Variable which checking if writeToFile method return true
            boolean writeTitle = fileRecources.fileManagerTitleOpenAI.writeToFile(input);
            if(writeTitle){
                alert.alertMessage("Succes","✅ Generating title");
            } else {
                alert.alertMessage("Fail","❌ Generating title fail!");
            }
            // refresh window after showing title
            refresh.refreshWindow(title, fileRecources.TITLE_PATH);
        } catch (Exception e) {
            alert.alertMessage("File/API Error", "Problem with saving or generating: " + e.getMessage());
        }
    }
}
