package EmailAIWindowApplication.CancelOption;

import EmailAIWindowApplication.Interfaces.CancelInterface;
import EmailAIWindowApplication.MenuProgram.Menu;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CancelOption implements CancelInterface {

    @Override
    public void cancel(Button cancel) {
        Stage currentlyWindow = (Stage) cancel.getScene().getWindow();
        currentlyWindow.close();
        try {
            new Menu().start(new Stage());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
