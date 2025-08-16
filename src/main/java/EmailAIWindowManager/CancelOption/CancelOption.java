package EmailAIWindowManager.CancelOption;

import EmailAIWindowManager.Interfaces.CancelInterface;
import EmailAIWindowManager.EmailAIWindowRun.EmailAIWindowRun;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CancelOption implements CancelInterface {

    @Override
    public void cancel(Button cancel) {
        Stage currentlyWindow = (Stage) cancel.getScene().getWindow();
        currentlyWindow.close();
        try {
            new EmailAIWindowRun().start(new Stage());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
