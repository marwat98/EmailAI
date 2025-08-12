package GmailSendMessage;

import AbstractClasses.EmailSendClass;
import FileResources.FileRecources;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GmailSend extends EmailSendClass {

    public GmailSend(String myEmail, String sendEmail, String topic, String description , String hostAdress, String password) {
        super(myEmail, sendEmail,topic,description,hostAdress, password);
    }

    @Override
    public void addProperty(String key, String value) {
        super.addProperty(key, value);
    }

    public void gmailPuts(){
        addProperty("mail.smtp.host", "smtp.gmail.com");
        addProperty("mail.smtp.port", "465");
        addProperty("mail.smtp.auth", "true");
        addProperty("mail.smtp.socketFactory.port", "465");
        addProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    }
    @Override
    public Session getSessionInstance() {
        return super.getSessionInstance();
    }

    public boolean sendMail() {
        try {
            MimeMessage message = new MimeMessage(getSessionInstance());
            message.setFrom(new InternetAddress(myEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendEmail));
            message.setSubject(topic);
            message.setText(description);

            Transport.send(message);
            System.out.println("Email sent successfully.");
            return true;

        } catch (MessagingException e) {
            System.out.println("Send failed, exception: " + e.getMessage());
        }
        return true;
    }
}

