package email;

import java.util.Properties;

public class Email {

    private final String emailSend;

    private final String emailPassword;

    private final String emailTo;

    private Properties properties;

    public Email(String emailSend, String emailPassword, String emailTo) {
        this.emailSend = new String(emailSend);
        this.emailPassword = new String(emailPassword);
        this.emailTo = new String(emailTo);
        this.properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
    }

    public String getEmailSend() {
        return emailSend;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public Properties getProperties() {
        return properties;
    }
}
