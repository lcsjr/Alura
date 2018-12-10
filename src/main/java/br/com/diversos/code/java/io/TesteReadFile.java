package br.com.diversos.code.java.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TesteReadFile {

	public static void main(String[] args) throws IOException {

		// Abaixo Fluxo de leitura de arquivo
		InputStream fis = new FileInputStream("aulaAlura.txt"); // abre em bytes
		Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		String linha = br.readLine();
		
		while(linha != null) {
			System.out.println(linha);
			linha = br.readLine();
		}
		
		br.close();
		
		// Abaixo Fluxo de leitura de arquivo
		InputStream fis2 = new FileInputStream("contas.csv"); // abre em bytes
		Reader isr2 = new InputStreamReader(fis2);
		BufferedReader br2 = new BufferedReader(isr2);
		
		String linha2 = br2.readLine();
		
		while(linha2 != null) {
			System.out.println(linha2);
			linha2 = br2.readLine();
		}
		
		br2.close();
	
	}

}
