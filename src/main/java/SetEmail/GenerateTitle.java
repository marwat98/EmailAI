package SetEmail;

import Alert.AlertClass;
import FileManagerClasses.FileManagerOpenAIClass;
import Interfaces.GenerateInterface;
import OpenAIConfigurator.OpenAIConfigurator;
import RefreshWindow.RefreshWindow;
import javafx.scene.control.TextInputControl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static SetEmail.SetEmail.MAIN_PACKAGE_FILES;

public class GenerateTitle implements GenerateInterface {

    final Path TITLE_PATH = Paths.get(MAIN_PACKAGE_FILES , "emailTitleFile.txt");
    final Path API_PATH = Paths.get(MAIN_PACKAGE_FILES , "APIKEY.txt");

    File apiFile = new File(String.valueOf(API_PATH));
    File titleFile = new File(String.valueOf(TITLE_PATH));

    FileManagerOpenAIClass fileManagerTitleOpenAI = new FileManagerOpenAIClass(titleFile.toPath());

    OpenAIConfigurator openAIConfigurator = new OpenAIConfigurator();
    String apiKey = fileManagerTitleOpenAI.readFile(apiFile);

    /**
     *
     * @param title TextArea for show title
     * @param alert class which show alert
     * @param refresh class which refresh window after finish operation
     */
    @Override
    public void generateOpenAI(TextInputControl title, AlertClass alert, RefreshWindow refresh) {
        try{
            // Variable which generate title using OpenAI
            String generateTitle  = openAIConfigurator.generate("Generate only one email title with greetings without description",apiKey);

            // Input which set generated title
            title.setText(generateTitle);

            // Variable which get title of input
            String input = title.getText();

            // Variable which checking if writeToFile method return true
            boolean writeTitle = fileManagerTitleOpenAI.writeToFile(input);
            if(writeTitle){
                alert.alertMessage("Succes","✅ Generating title");
            } else {
                alert.alertMessage("Fail","❌ Generating title fail!");
            }
            // refresh window after showing title
            refresh.refreshWindow(title, TITLE_PATH);
        } catch (Exception e) {
            alert.alertMessage("File/API Error", "Problem with saving or generating: " + e.getMessage());
        }
    }
}
