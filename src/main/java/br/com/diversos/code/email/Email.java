package br.com.diversos.code.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
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

//		FuncionalidadesUteis utilidade = new FuncionalidadesUteis();

		//String to = destinatarios;
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
        session.setDebug(true);
        
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			
			Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(destinatarios); 
			
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(assuntoEmail);
			message.setText(corpoEmailString);
			
			
//			BodyPart messageBodyPart = new MimeBodyPart();
//			BodyPart messageBodyPart2 = new MimeBodyPart();
//
//			messageBodyPart.setText(corpoEmailString);
//
//			Multipart multipart = new MimeMultipart();
//			multipart.addBodyPart(messageBodyPart);
//
//			messageBodyPart = new MimeBodyPart();
//			String filename = "aulaAlura.txt";
//			DataSource source = new FileDataSource(filename);
//			messageBodyPart.setDataHandler(new DataHandler(source));
//			messageBodyPart.setFileName(filename);
//
//			//if (utilidade.pastaVazia("./evidencias/integracao") == false || utilidade.pastaVazia("./evidencias/screenshot") == false || utilidade.pastaVazia("./evidencias/WS") == false) {
//
////				String anexoEvidencias = zipaEvidencias();
////				messageBodyPart2 = new MimeBodyPart();
////				String filename2 = anexoEvidencias;
////				DataSource source2 = new FileDataSource(filename2);
////				messageBodyPart2.setDataHandler(new DataHandler(source2));
////				messageBodyPart2.setFileName("comparacao.zip");
////				multipart.addBodyPart(messageBodyPart2);
//			//}
//
//			multipart.addBodyPart(messageBodyPart);
//
//			message.setContent(multipart);
			Transport.send(message);

//			logger.info(String.format("--------------------------------------------------------------------------------------------------------------------------------"));
//			logger.info("E-MAIL COM AS INFORMAÇÕES DA SUITE ENVIADO COM SUCESSO! ");
//			logger.info(String.format("--------------------------------------------------------------------------------------------------------------------------------"));

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String zipaEvidencias() {
		String[] u = null;
		Zip.main(u);
		String evidenciasZip = "./testeZipar/comparacao.zip";
		return evidenciasZip;
	}
	
}
