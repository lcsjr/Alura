package br.com.diversos.code.email;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
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

public class Email {

	public void enviaEmailComAnexos(String destinatarios, String assuntoEmail, String corpoEmailString) throws UnsupportedEncodingException {

		String fileName = "./target/comparacao_TabelasDinamicas.zip";
		String from = "tr.automation.webdriver@gmail.com";
		final String username = "tr.automation.br@gmail.com";
		final String password = "Autom@t1on";
		String host = "smtp.gmail.com";
		
		Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

        /** Ativa Debug para sessão */
        session.setDebug(false);
		try {

			Address[] toUser = InternetAddress.parse(destinatarios);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(assuntoEmail);
			
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText(corpoEmailString);
						
			BodyPart messageBodyPart2 = new MimeBodyPart();			
			FileDataSource source = new FileDataSource(fileName);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(source.getName());			

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);
			
			message.setContent(multipart);
			message.setSentDate(new Date());
			Transport.send(message);

		} catch (MessagingException mex) {
		      mex.printStackTrace();
		      Exception ex = null;
		      if ((ex = mex.getNextException()) != null) {
		    	  ex.printStackTrace();
		      }
		  }
	}
	
}
