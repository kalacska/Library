package org.pmmik.email;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.MimeMessageHelper;

public class Email {
	
	
	// Recipient's email ID needs to be mentioned.
			String to = "p.kalacska@gmail.com";// change accordingly

			// Sender's email ID needs to be mentioned
			String from = "magyarlibrary@gmail.com";// change accordingly
			final String username = "magyarlibrary";// change accordingly
			final String password = "12345678*0";// change accordingly
			FileSystemResource file = new FileSystemResource("C:\\book_database.xml");
			

			// Assuming you are sending email through relay.jangosmtp.net
			String host = "smtp.gmail.com";
			
			Properties props = new Properties();
			
			// Get the Session object.
			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					});
				
			
			public Email() {
				super();
				props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", "587");
				// TODO Auto-generated constructor stub
			}
			
			
			public boolean sendMail(String Subject,String Text,String email){
				try {
					// Create a default MimeMessage object.
					Message message = new MimeMessage(session);
					

					// Set From: header field of the header.
					message.setFrom(new InternetAddress(from));

					// Set To: header field of the header.
					List<InternetAddress>emails = new ArrayList<InternetAddress>();
					message.addRecipients(Message.RecipientType.TO,
							InternetAddress.parse(to));
					message.addRecipients(Message.RecipientType.TO,
							InternetAddress.parse(email));
					/*message.addRecipients(Message.RecipientType.TO,
							InternetAddress.parse(email));*/
					// Set Subject: header field
					message.setSubject(Subject);

					// Now set the actual message
					message.setText(Text);

					MimeMessageHelper helper=new MimeMessageHelper((MimeMessage) message,true);
					helper.addAttachment(file.getFilename(), file);
					
					
					// Send message
					Transport.send(message);

				
					
					
					return true;

				} catch (MessagingException e) {
					
					throw new RuntimeException(e);
					
				}
				
			}


			public String getTo() {
				return to;
			}


			public void setTo(String to) {
				this.to = to;
			}
			
			
}