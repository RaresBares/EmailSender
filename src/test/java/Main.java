import java.nio.charset.Charset;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Main {

    public static void main(String [] args) {
        System.out.println(ranstr());
        for (int i = 0; i < 1; i++) {
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String to = "";


            String from = "Klkein@fatale-randale.de";
            final String username = "Klkein@fatale-randale.de";
            final String password = "Klkein";

            String host = "cmail01.mc-host24.de";


            Properties properties = System.getProperties();


            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            properties.put("mail.smtp.port", "25");
            properties.setProperty("mail.smtp.host", host);


            Session session;
            session = Session.getDefaultInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {
                MimeMessage message = new MimeMessage(session);


                message.setFrom(new InternetAddress(from));


                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));


                message.setSubject("Hey Du Wixxer");


                message.setText("Du bist ein wixxer");



                Transport.send(message);


                System.out.println("Sent message successfully....");
            } catch (MessagingException mex) {
                mex.printStackTrace();
            }
        }
    }
    public static String ranstr() {
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}