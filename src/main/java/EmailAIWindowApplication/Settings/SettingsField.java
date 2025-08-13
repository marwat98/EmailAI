package EmailAIWindowApplication.Settings;

public class SettingsField {
    private String checkAPIKey;
    private String choosePostOfficeOption;
    private String checkHostAddress;
    private String checkPostPassword;
    private String checkPlaceOfChoice;

    public SettingsField(String checkAPIKey,String choosePostOfficeOption,String checkHostAddress,String checkPostPassword,String checkPlaceOfChoice){
        this.checkAPIKey = checkAPIKey;
        this.choosePostOfficeOption = choosePostOfficeOption;
        this.checkHostAddress = checkHostAddress;
        this.checkPostPassword = checkPostPassword;
        this.checkPlaceOfChoice = checkPlaceOfChoice;
    }
    public String getCheckAPIKey(){
        return checkAPIKey;
    }

    public String getChoosePostOfficeOption() {
        return choosePostOfficeOption;
    }

    public String getCheckHostAddress() {
        return checkHostAddress;
    }

    public String getCheckPostPassword() {
        return checkPostPassword;
    }

    public String getCheckPlaceOfChoice() {
        return checkPlaceOfChoice;
    }
}
