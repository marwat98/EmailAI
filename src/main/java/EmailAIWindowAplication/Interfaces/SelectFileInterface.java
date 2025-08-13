package EmailAIWindowAplication.Interfaces;

import EmailAIWindowAplication.Alert.AlertClass;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public interface SelectFileInterface {
    void selectFile(Label showSelectFile, AlertClass alert, Stage stage);
}
