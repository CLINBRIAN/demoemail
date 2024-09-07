import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.mail.*;
import java.util.*;
import javax.mail.*;



public class SendEMail {
	public static void main(String[] args) {

		String to="peaceambassadorskarateleague@gmail.com";
		String from="kamauclinbriant100@gmail.com";
		//String host="localhost";
		
		//get system properties
		Properties properties =new Properties();
		//set up mail server
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port",587);
		
		Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("kamauclinbriant100@gmail.com","@Egacie12");
			}
		});
		

		try {
			//create a default MimeMessage object
			MimeMessage message = new MimeMessage(session);
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
	         // Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to) );
			// Set Subject: header field
			message.setSubject("This is the subject Line!");
			 // Now set the actual message
			message.setText("This is the actual message");
			// Send message
			Transport.send(message);
			System.out.println("Message sent successfully");
			
		} catch (MessagingException mex) {
			// TODO: handle exception
			mex.printStackTrace();
		}
		
		
		
		
	}

}
