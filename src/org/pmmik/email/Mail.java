package org.pmmik.email;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {

	private String to = "p.kalacska@gmail.com"; //$NON-NLS-1$

	public void main() {
		// Recipient's email ID needs to be mentioned.

		// Sender's email ID needs to be mentioned
		String from = "magyarlibrary@gmail.com"; //$NON-NLS-1$

		final String username = "magyarlibrary";//change accordingly //$NON-NLS-1$
		final String password = "12345678*0";//change accordingly //$NON-NLS-1$

		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com"; //$NON-NLS-1$

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true"); //$NON-NLS-1$ //$NON-NLS-2$
		props.put("mail.smtp.starttls.enable", "true"); //$NON-NLS-1$ //$NON-NLS-2$
		props.put("mail.smtp.host", host); //$NON-NLS-1$
		props.put("mail.smtp.port", "25"); //$NON-NLS-1$ //$NON-NLS-2$

		// Get the Session object.
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(this.to));

			// Set Subject: header field
			message.setSubject("message"); //$NON-NLS-1$

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Now set the actual message
			messageBodyPart.setText("Message from Library!"); //$NON-NLS-1$

			// Create a multipar message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			String filename = "\\book_database.xml"; //$NON-NLS-1$
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);

			// Send message
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public String getTo() {
		return this.to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}