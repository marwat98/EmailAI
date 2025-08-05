package SetEmail;

import Alert.AlertClass;
import FileResources.FileRecources;
import RefreshWindow.RefreshWindow;
import javafx.scene.control.TextInputControl;


public class GenerateDescription extends GenerateTitle {

    // class where are paths , files , objects to serve methods
    FileRecources fileRecources = new FileRecources();

    /**
     *
     * @param description TextArea for show description
     * @param alert class which show alert
     * @param refresh class which refresh window after finish operation
     */
    @Override
    public void generateOpenAI(TextInputControl description, AlertClass alert, RefreshWindow refresh) {
        // Variable which read api key of file
        String apiKeyDescription = fileRecources.fileManagerDescriptionOpenAI.readFile(fileRecources.apiFile);

        // Variable which read title of file
        String readTitle = fileRecources.fileManagerDescriptionOpenAI.readFile(fileRecources.titleFile);

        // Varaible which set description to generating
        String generateDescription  = openAIConfigurator.generate("Generate a description based on the title inside the file I added"
                + readTitle +
                "Sentence have to max 10 words on the end write Look more and click in link below additionaly in the next line add link of file"
                + fileRecources.readLinkOfFile.showContent()
                + "and add one empty next line and second Your sincerely Sales Menager AI",apiKeyDescription);

        // Variable which set generated text in field
        description.setText(generateDescription);

        // Variable which show description in TextField
        String inputDescription = description.getText();

        boolean writeDescription = fileRecources.fileManagerDescriptionOpenAI.writeToFile(inputDescription);
        if(writeDescription){
            alert.alertMessage("Succes","✅ Generating descirption");
        } else {
            alert.alertMessage("Fail","❌ Generating description fail!");
        }
        // refresh window after showing description
        refresh.refreshWindow(description,fileRecources.DESTRIPTION_PATH);
    }
}
