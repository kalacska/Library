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
	String to = "p.kalacska@gmail.com";// change accordingly //$NON-NLS-1$

	// Sender's email ID needs to be mentioned
	String from = "magyarlibrary@gmail.com";// change accordingly //$NON-NLS-1$
	final String username = "magyarlibrary";// change accordingly //$NON-NLS-1$
	final String password = "12345678*0";// change accordingly //$NON-NLS-1$
	FileSystemResource file = new FileSystemResource("C:\\book_database.xml"); //$NON-NLS-1$

	// Assuming you are sending email through relay.jangosmtp.net
	String host = "smtp.gmail.com"; //$NON-NLS-1$

	Properties props = new Properties();

	// Get the Session object.
	Session session = Session.getInstance(this.props,
			new javax.mail.Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(Email.this.username,
							Email.this.password);
				}
			});

	public Email() {
		super();
		this.props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); //$NON-NLS-1$ //$NON-NLS-2$
		this.props.put("mail.smtp.auth", "true"); //$NON-NLS-1$ //$NON-NLS-2$
		this.props.put("mail.smtp.starttls.enable", "true"); //$NON-NLS-1$ //$NON-NLS-2$
		this.props.put("mail.smtp.host", this.host); //$NON-NLS-1$
		this.props.put("mail.smtp.port", "587"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public boolean sendMail(String Subject, String Text, String email) {
		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(this.session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(this.from));

			// Set To: header field of the header.
			List<InternetAddress> emails = new ArrayList<InternetAddress>();
			message.addRecipients(Message.RecipientType.TO,
					InternetAddress.parse(this.to));
			message.addRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			/*
			 * message.addRecipients(Message.RecipientType.TO,
			 * InternetAddress.parse(email));
			 */
			// Set Subject: header field
			message.setSubject(Subject);

			// Now set the actual message
			message.setText(Text);

			MimeMessageHelper helper = new MimeMessageHelper(
					(MimeMessage) message, true);
			helper.addAttachment(this.file.getFilename(), this.file);

			// Send message
			Transport.send(message);

			return true;

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