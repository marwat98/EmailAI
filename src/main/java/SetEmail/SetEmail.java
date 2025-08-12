package SetEmail;

import ButtonManager.ButtonManager;
import CancelOption.CancelOption;
import FileManagerClasses.FileManagerOpenAIClass;
import FileManagerClasses.FileManagerClass;
import Alert.AlertClass;
import FileResources.FileRecources;
import Interfaces.WindowViewInterface;
import RefreshWindow.RefreshWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class SetEmail implements WindowViewInterface{

    // class where are paths , files , objects to serve methods
    FileRecources fileRecourcesSetEmail = new FileRecources();

    public TextField fromSetEmail = new TextField();
    public TextField title = new TextField();
    public TextArea description = new TextArea();
    public Separator separator = new Separator();
    public RefreshWindow refresh = new RefreshWindow();
    public ButtonManager button = new ButtonManager();
    public AlertClass alert = new AlertClass();
    public Stage stage = new Stage();


    /**
     * method which have title window
     * @param hbox which contain position in window
     * @param labelText variable which contain title window
     * @return HBox
     */
    @Override
    public HBox title(HBox hbox,String labelText){
        Label writeYourEmail = new Label(labelText);
        writeYourEmail.setFont(Font.font(15));

        hbox.setAlignment(Pos.TOP_LEFT);
        HBox.setMargin(writeYourEmail,new Insets(25,0,0,100));
        hbox.getChildren().addAll(writeYourEmail);

        return hbox;
    }

    /**
     * method which conatain field for your email, title email , description email
     * @param vbox position on window place
     * @return vbox of settings position inputs on window
     */
    @Override
    public VBox inputPartOfWindow(VBox vbox ) {
        // Label and TextField for From email input and HBox
        Label fromEmailLabel = new Label("From");
        fromEmailLabel.setFont(Font.font(15));
        fromSetEmail.setPrefSize(530,20);

        HBox fromRow = new HBox();
        fromRow.setAlignment(Pos.TOP_LEFT);
        fromRow.getChildren().addAll(fromEmailLabel,fromSetEmail);
        HBox.setMargin(fromEmailLabel,new Insets(15,40,0,15));
        HBox.setMargin(fromSetEmail,new Insets(15,0,0,10));

        //Loop which show email in input fromSetEmail
        String myEmailData = fileRecourcesSetEmail.fileSetYourEmailClass.showContent();
        fromSetEmail.setText(myEmailData);

        // Label and TextField for To email input and HBox
        Label toEmailLabel = new Label("To");
        toEmailLabel.setFont(Font.font(15));
        Label showSelectFile = new Label("No select file");

        Button select = button.setButtonSize("Select File",200, 20);
        select.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                SelectFile selectFile = new SelectFile();
                selectFile.selectFile(showSelectFile,alert,stage);
            }
        });

        HBox toRow = new HBox();
        toRow.setAlignment(Pos.TOP_LEFT);
        toRow.getChildren().addAll(toEmailLabel,select,showSelectFile);
        HBox.setMargin(toEmailLabel,new Insets(15,57,0,15));
        HBox.setMargin(select,new Insets(15,0,0,10));
        HBox.setMargin(showSelectFile,new Insets(20,0,0,10));

        //Label,TextField,Hbox for title input
        Label titleLabel = new Label("Title");
        titleLabel.setFont(Font.font(15));
        title.setPrefSize(530,20);

        HBox titleRow = new HBox();
        titleRow.setAlignment(Pos.TOP_LEFT);
        titleRow.getChildren().addAll(titleLabel,title);
        HBox.setMargin(titleLabel,new Insets(15,45,0,15));
        HBox.setMargin(title,new Insets(15,0,0,10));

        // Loop which show title text in input
        String showTitleAI = fileRecourcesSetEmail.saveTitleOpenAI.showContent();
        title.setText(showTitleAI);

        //Label,TextArea,HBox for Description Email
        Label descriptionLabel = new Label("Description");
        descriptionLabel.setFont(Font.font(15));
        description.setPrefSize(530,130);

        HBox descriptionRow = new HBox();
        descriptionRow.setAlignment(Pos.TOP_LEFT);
        descriptionRow.getChildren().addAll(descriptionLabel,description);
        HBox.setMargin(descriptionLabel,new Insets(45,-2,0,15));
        HBox.setMargin(description,new Insets(15,0,0,10));

        String showDescriptionAI = fileRecourcesSetEmail.descriptionOpenAI.showContent();
        description.setText(showDescriptionAI);

        //Button to generate title using OpenAI
        Button generateTitleButton = button.setButtonSize("Generate Title",200,20);
        generateTitleButton.setOnAction(e->{
            GenerateTitle generateTitle = new GenerateTitle();
            generateTitle.generateOpenAI(title,alert,refresh);
        });

        //Button to generate description using OpenAI
        Button generateDescriptionButton = button.setButtonSize("Generate Description",200, 20);
        generateDescriptionButton.setOnAction(e->{
           GenerateDescription generateDescription = new GenerateDescription();
           generateDescription.generateOpenAI(description,alert,refresh);
        });

        // HBox for title and description
        HBox buttonRow = new HBox();
        buttonRow.setAlignment(Pos.BOTTOM_CENTER);
        buttonRow.getChildren().addAll(generateTitleButton, generateDescriptionButton);
        HBox.setMargin(generateTitleButton,new Insets(10,0,0,0));
        HBox.setMargin(generateDescriptionButton,new Insets(10,0,0,10));

        vbox.getChildren().addAll(fromRow,toRow,titleRow,descriptionRow, buttonRow);

        return vbox;
    }

    /**
     * method which set separator position on window
     * @param vboxSeparator
     * @return vbox with settings separator position
     */
    @Override
    public VBox separator(VBox vboxSeparator){
        separator.setPrefWidth(200);

        VBox.setMargin(separator, new Insets(40, 0, 0, 0));
        vboxSeparator.getChildren().addAll(separator);

        return vboxSeparator;
    }

    /**
     * method with button cancel and save
     * @param hbox class which contain position in window
     * @return hbox with position buttons cancel and save in window
     */
    @Override
    public HBox buttonPartOfWindow(HBox hbox) {
        Button cancel = button.setButtonSize("Cancel",100, 20);
        Button save = button.setButtonSize("Save",100, 20);

        // Action returning to menu window
        cancel.setOnAction( e->{
            CancelOption cancelOption = new CancelOption();
            cancelOption.cancel(cancel);
        });

        // Action which save options
        save.setOnAction(e->{
            SaveSetEmailSettings saveSetEmailSettings = new SaveSetEmailSettings();
            saveSetEmailSettings.save(fromSetEmail,title,alert,refresh);
        });

        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        HBox.setMargin(cancel,new Insets(10,0,12,35));
        HBox.setMargin(save,new Insets(10,10,12,10));
        hbox.getChildren().addAll(cancel,save);

        return hbox;
    }
}