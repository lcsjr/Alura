package br.com.diversos.code.java.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class TesteProperties {

	public static void main(String[] args) throws IOException {

		Properties props = new Properties();
		props.setProperty("login", "alura");
		props.setProperty("senha", "alurapass");
		props.setProperty("endereco", "www.alura.com.br");
		
		props.store( new FileWriter("conf.properties") , "arquivo de configuracao com as propriedades que eu criei.");
	
		System.out.println("Arquivo criado com sucesso na raiz do diretório deste projeto!");
		System.out.println();
		
		Properties propRead = new Properties();
		propRead.load(new FileReader("conf.properties"));
		
		String login = propRead.getProperty("login");
		String senha = propRead.getProperty("senha");
		String endereco = propRead.getProperty("endereco");
		
		String exibe = String.format(new Locale("pt","BR"), "Usuario é %s e sua senha de acesso ao site %s é %s.", login, endereco, senha);
		System.out.println(exibe);
	
	}

}
