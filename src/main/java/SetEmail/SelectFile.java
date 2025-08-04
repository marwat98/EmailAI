package SetEmail;

import Alert.AlertClass;
import FileManagerClasses.FileManagerClass;
import FileManagerClasses.FileManagerOpenAIClass;
import Interfaces.SelectFileInterface;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static SetEmail.SetEmail.MAIN_PACKAGE_FILES;

public class SelectFile implements SelectFileInterface {
    final Path SEND_EMAIL_PATH = Paths.get(MAIN_PACKAGE_FILES, "sendEmailFile.txt");
    final Path SEARCH_POLE = Paths.get(MAIN_PACKAGE_FILES,"searchPoleDirection.txt");

    File testFile = new File(String.valueOf(SEND_EMAIL_PATH));
    File searchPoleFile = new File(String.valueOf(SEARCH_POLE));

    FileManagerClass searchPole = new FileManagerClass(searchPoleFile.toPath());

    /**
     *
     * @param showSelectFile Label which show communicate that No select file
     * @param alert class which show alert
     * @param stage class which create stage
     */
    @Override
    public void selectFile(Label showSelectFile, AlertClass alert, Stage stage) {
        String search = searchPole.showContent();
        if(search == null || search.trim().isEmpty()){
            alert.alertMessage("Unknown position", "Check if your position is setting");
            return;
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose email file");
        fileChooser.setInitialDirectory(new File(search.trim()));
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );

        File selectFile = fileChooser.showOpenDialog(stage);
        if(selectFile == null){
            alert.alertMessage("No File Selected", "You didn't choose a file.");
            return;
        }

        try{
            FileManagerClass fileManagerSelectFile = new FileManagerClass(selectFile.toPath());
            String selectFileContent = fileManagerSelectFile.showContent();
            FileManagerOpenAIClass writeToFileTest = new FileManagerOpenAIClass(testFile.toPath());

            if(selectFile != null){
                showSelectFile.setText( "Selected file: " + selectFile);
                writeToFileTest .writeToFile(selectFileContent);
            } else {
                alert.alertMessage("Don't choose file", "You don't choosing file");
            }
        } catch(Exception e){
                alert.alertMessage("File Error", "Could not read or write the file: " + e.getMessage());
        }
    }
}
