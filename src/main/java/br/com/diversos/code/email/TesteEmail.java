package br.com.diversos.code.email;

import java.io.UnsupportedEncodingException;

public class TesteEmail {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		
		
		
			String destinatarios =  "luiz.santos@thomsonreuters.com";//destinatariosSuite;
			String assuntoEmail = "Teste Email";//auxReultados.montaAssuntoEmail(CabecalhoDeResultado);
			String corpoEmailString = "Teste testando.."; //auxReultados.montaCorpoEmail(corpoEmail);
			System.out.println("Inicio");
			Email email = new Email();
			email.enviaEmailComAnexos(destinatarios, assuntoEmail, corpoEmailString);
			
			System.out.println("Fim");

	}

}
