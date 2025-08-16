package EmailAITerminalRun;

import EmailAIWindowManager.FileResources.FileRecources;
import EmailAIWindowManager.EmailSend.EmailSend;

public class EmailAITerminalRun {
    public static void main(String[] args) {
        FileRecources fileRecourcesSendMessages = new FileRecources();

        String myEmail = fileRecourcesSendMessages.fileSetYourEmailClass.showContent();
        String sendEmail = fileRecourcesSendMessages.fileSendYourEmailClass.showContent();
        String topic = fileRecourcesSendMessages.fileManagerTitleOpenAI.showContent();
        String description = fileRecourcesSendMessages.description.showContent();
        String hostAdress = fileRecourcesSendMessages.hostAddressSave.showContent();
        String password = fileRecourcesSendMessages.postPasswordSave.showContent();
        String readChoosePostOffice = fileRecourcesSendMessages.postOfficeChoose.showContent();

        EmailSend emailSend = new EmailSend(myEmail,sendEmail,hostAdress,password);

        switch (readChoosePostOffice.trim()){
            case "Gmail":
                emailSend.emailPuts("smtp.gmail.com","465");
                emailSend.sendEmail(topic,description);
                break;
            case "Outlook":
                emailSend.emailPuts("smtp.office365.com","587");
                emailSend.sendEmail(topic,description);
                break;
            case "Wp":
                emailSend.emailPuts("smtp.wp.com","465");
                emailSend.sendEmail(topic,description);
                break;
            case "Onet":
                emailSend.emailPuts("smtp.poczta.onet.p","465");
                emailSend.sendEmail(topic,description);
                break;
        }

    }

}
