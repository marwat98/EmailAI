package EmailAIWindowApplication.SetEmail;

import EmailAIWindowApplication.Alert.AlertClass;
import EmailAIWindowApplication.FileManagerClasses.FileManagerClass;
import EmailAIWindowApplication.FileManagerClasses.FileManagerOpenAIClass;
import EmailAIWindowApplication.FileResources.FileRecources;
import EmailAIWindowApplication.Interfaces.SelectFileInterface;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;


public class SelectFile implements SelectFileInterface {

    // class where are paths , files , objects to serve methods
    FileRecources fileRecourcesSetFile = new FileRecources();

    /**
     *
     * @param showSelectFile Label which show communicate that No select file
     * @param alert class which show alert
     * @param stage class which create stage
     */
    @Override
    public void selectFile(Label showSelectFile, AlertClass alert, Stage stage) {
        String search = fileRecourcesSetFile.searchPole.showContent();
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
            FileManagerOpenAIClass writeToFileTest = new FileManagerOpenAIClass(fileRecourcesSetFile.sendEmailFile.toPath());

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
