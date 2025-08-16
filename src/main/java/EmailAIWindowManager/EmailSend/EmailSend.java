package EmailAIWindowManager.EmailSend;

import EmailAIWindowManager.AbstractClasses.EmailSendClass;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSend extends EmailSendClass {

    public EmailSend(String myEmail, String sendEmail, String hostAdress, String password) {
        super(myEmail, sendEmail,hostAdress, password);
    }

    @Override
    public void addProperty(String key, String value) {
        super.addProperty(key, value);
    }

    public void emailPuts(String postSmtp, String port){
        addProperty("mail.smtp.host", postSmtp);
        addProperty("mail.smtp.port", port);
        addProperty("mail.smtp.auth", "true");
        addProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    }
    @Override
    public Session getSessionInstance() {
        return super.getSessionInstance();
    }

    public void sendEmail(String topic , String description) {
        try {
            MimeMessage message = new MimeMessage(getSessionInstance());
            message.setFrom(new InternetAddress(myEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendEmail));
            message.setSubject(topic);
            message.setText(description);

            if(myEmail.isEmpty() && sendEmail.isEmpty() && topic.isEmpty() && description.isEmpty()){
                System.out.println("Email can't be send check email , topic , description field in window settings");
            } else {
                Transport.send(message);
                System.out.println("Email sent successfully.");
            }
        } catch (MessagingException e) {
            System.out.println("Send failed, exception: " + e.getMessage());
        }
    }
}

