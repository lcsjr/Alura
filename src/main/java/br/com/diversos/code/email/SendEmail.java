package br.com.diversos.code.email;

import java.io.UnsupportedEncodingException;

public class SendEmail {

	public static void main(String[] args) throws UnsupportedEncodingException {

		Email email = new Email();
		
		email.enviaEmailComAnexos("luiz.santos@thomsonreuters.com", "Teste Email", "Teste Testando...");

	}

}
