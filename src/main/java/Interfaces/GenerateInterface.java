package Interfaces;

import Alert.AlertClass;
import FileManagerClasses.FileManagerOpenAIClass;
import RefreshWindow.RefreshWindow;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputControl;

public interface GenerateInterface {
    void generateOpenAI(TextInputControl textInputControl, AlertClass alert, RefreshWindow refresh);
}
