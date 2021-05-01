import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

// represents a class that can send an email
// most of the code for sending the email is credited to: https://www.javatpoint.com/example-of-sending-email-using-java-mail-api-through-gmail-server
public class EmailSender {

    // EFFECTS: sends email containing the update in the message body
    public static void sendEmail(String update) {
        final String user = "xxx@gmail.com";
        final String password = "xxx";

        String to = "xxx@msg.telus.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
                });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("BC COVID-19 Updates");
            message.setText(update);

            Transport.send(message);

            System.out.println("Message sent to " + to);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    // EFFECTS: if update is not an empty string, sends an email
    public static void checkUpdate(String update) {
        if (!update.equals("")) {
            sendEmail(update);
        }
    }

}
