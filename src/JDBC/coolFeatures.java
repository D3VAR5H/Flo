package JDBC;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.mail.internet.AddressException;
import javax.xml.bind.DatatypeConverter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/* Remotemysql.com
Username: BpbJIEdPGV

Password: SlEspToCBe

Database Name: BpbJIEdPGV

Server: remotemysql.com

Port: 3306
*/

// Creating connection to the provided Database
final class DataRetrieve {

    protected Connection con;
    protected Statement stmt;
    protected PreparedStatement pstmt;

    DataRetrieve() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/hjvBcSSnA6", "hjvBcSSnA6", "3OBTmkbwFb");
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Using Hash Function to create Hash encryption of password for more security
final class passwordHash {

    public static String getHash(String inputPassword) {
        byte[] inputpassword = inputPassword.getBytes();
        String hashPassword = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(inputpassword);
            byte[] digestedByte = messageDigest.digest();
            hashPassword = DatatypeConverter.printHexBinary(digestedByte).toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashPassword;
    }
}

final public class coolFeatures {

    public static void sendMail(String mail, int OTP) {
        // Recipient's email ID needs to be mentioned.
        String to = mail;//change accordingly
        // Sender's email ID needs to be mentioned
        String from = "flomusicprime@gmail.com";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props, new GmailAuthenticator());

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("FLO Signup Confirmation");

            // Now set the actual message
            message.setText("Your OTP for signup in our service is "+ OTP);

            // Send message
            Transport.send(message);
            
        } catch (AddressException ex) {
        } catch (MessagingException ex) {
        }
    }
}

class GmailAuthenticator extends javax.mail.Authenticator {

    final String username = "flomusicprime@gmail.com";//change accordingly
    final String pwd = "flomusic1469312";//change accordingly

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, pwd);
    }
}