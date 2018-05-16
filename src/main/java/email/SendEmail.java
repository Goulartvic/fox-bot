package email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

    private Email emailConfig;

    public void sendBitcoinPrice(double bitcoinPrice, String emailTo) {
        emailConfig = new Email("", "", emailTo);

        Session session = Session.getDefaultInstance(emailConfig.getProperties(), new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailConfig.getEmailSend(), emailConfig.getEmailPassword());
            }
        });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailConfig.getEmailSend()));

            Address[] toUser = InternetAddress.parse(emailConfig.getEmailTo());

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("COTAÇÃO FOXBOT!");
            message.setText("A atual cotação da bitcoin é: " + bitcoinPrice);
            Transport.send(message);

            System.out.println("E-mail enviado");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
