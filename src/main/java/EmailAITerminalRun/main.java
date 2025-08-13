package EmailAITerminalRun;

import EmailAIWindowAplication.FileResources.FileRecources;
import EmailAITerminalRun.GmailSendMessage.GmailSend;

public class main {
    public static void main(String[] args) {
        FileRecources fileRecourcesGmailSend = new FileRecources();
        String myEmail = fileRecourcesGmailSend.fileSetYourEmailClass.showContent();
        String sendEmail = fileRecourcesGmailSend.fileSendYourEmailClass.showContent();
        String topic = fileRecourcesGmailSend.fileManagerTitleOpenAI.showContent();
        String description = fileRecourcesGmailSend.fileManagerTitleOpenAI.showContent();
        String hostAdress = fileRecourcesGmailSend.hostAddressSave.showContent();
        String password = fileRecourcesGmailSend.postPasswordSave.showContent();


        GmailSend gmail = new GmailSend(myEmail,sendEmail,hostAdress,password);
        gmail.gmailPuts();
        boolean sendGmail = gmail.sendMail(topic,description);

        if(sendGmail != false){
            System.out.println("Something wrong check settings!!!");
        } else {
            System.out.println("You send email");
        }
    }

}
