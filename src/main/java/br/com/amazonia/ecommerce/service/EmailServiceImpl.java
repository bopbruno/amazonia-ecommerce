package br.com.amazonia.ecommerce.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public final class EmailServiceImpl {

	private static EmailServiceImpl emailService = new EmailServiceImpl();

	private static String USER_NAME = "boppedrosa@gmail.com";
	private static String PASSWORD = "Teste@123";
	

	public EmailServiceImpl() {
	}

	public static EmailServiceImpl getInstance() {
		return emailService;
	}

	public boolean enviarEmail(String destinatario, String assuntoEmail, String corpoEmail) {

		String from = USER_NAME;
		String pass = PASSWORD;
		String[] to = { destinatario };
		
		String subject = assuntoEmail;
		String body = corpoEmail;
		
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress = new InternetAddress[to.length];

			for (int i = 0; i < to.length; i++) {
				toAddress[i] = new InternetAddress(to[i]);
			}

			for (int i = 0; i < toAddress.length; i++) {
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}

			message.setSubject(subject);
			message.setText(body);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception ae) {
			ae.printStackTrace();
			return false;
		}

		return true;
	}

}
