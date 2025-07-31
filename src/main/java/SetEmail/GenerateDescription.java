package SetEmail;

import Alert.AlertClass;
import FileManagerClasses.FileManagerClass;
import FileManagerClasses.FileManagerOpenAIClass;
import RefreshWindow.RefreshWindow;
import javafx.scene.control.TextInputControl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static SetEmail.SetEmail.MAIN_PACKAGE_FILES;

public class GenerateDescription extends GenerateTitle {

    final Path DESTRIPTION_PATH = Paths.get(MAIN_PACKAGE_FILES , "descriptionFile.txt");
    final Path LINK = Paths.get(MAIN_PACKAGE_FILES, "link.txt");

    File descriptionFile = new File(String.valueOf(DESTRIPTION_PATH));
    File linkFile = new File(String.valueOf(LINK));

    FileManagerClass readLinkOfFile = new FileManagerClass(linkFile.toPath());
    FileManagerOpenAIClass fileManagerDescriptionOpenAI = new FileManagerOpenAIClass(descriptionFile.toPath());

    String apiKey = fileManagerDescriptionOpenAI.readFile(apiFile);

    /**
     *
     * @param description TextArea for show description
     * @param alert class which show alert
     * @param refresh class which refresh window after finish operation
     */
    @Override
    public void generateOpenAI(TextInputControl description, AlertClass alert, RefreshWindow refresh) {

        // Variable which read title File
        String readTitle = fileManagerDescriptionOpenAI.readFile(titleFile);

        // Varaible which set description to generating
        String generateDescription  = openAIConfigurator.generate("Generate a description based on the title inside the file I added"
                + readTitle +
                "Sentence have to max 10 words on the end write Look more and click in link below additionaly in the next line add link of file" + readLinkOfFile.showContent()
                + "and add one empty next line and second Your sincerely Sales Menager AI",apiKey);

        description.setText(generateDescription);

        // Variable which show description in TextField
        String inputDescription = description.getText();

        boolean writeDescription = fileManagerDescriptionOpenAI.writeToFile(inputDescription);
        if(writeDescription){
            alert.alertMessage("Succes","✅ Generating descirption");
        } else {
            alert.alertMessage("Fail","❌ Generating description fail!");
        }
        // refresh window after showing description
        refresh.refreshWindow(description,DESTRIPTION_PATH);
    }
}
