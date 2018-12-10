package br.com.diversos.code.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class TesteTeclado {

	public static void main(String[] args) throws IOException{

		// Abaixo Fluxo de leitura por entrada com teclado
		InputStream fis = System.in;								//new FileInputStream("aulaAlura.txt"); // abre em bytes
		Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		
		// Abaixo Fluxo de escrita no arquivo
		OutputStream fos = new FileOutputStream("aulaAlura_SaidaTeclado.txt"); // abre em bytes
		Writer wsr = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(wsr);
		
		String linha = br.readLine();
		
		while(linha != null && !linha.isEmpty() ) {
			bw.write(linha);
			bw.newLine();
			linha = br.readLine();
		}
		
		br.close();
		bw.close();
	}

}
