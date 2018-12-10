package br.com.diversos.code.java.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TesteWriteFile2 {

	public static void main(String[] args) throws IOException {

	// Abaixo Fluxo de leitura de arquivo
//	OutputStream fos = new FileOutputStream("aulaAlura_Saida.txt"); // abre em bytes
//	Writer wsr = new OutputStreamWriter(fos);
//	BufferedWriter bw = new BufferedWriter(wsr);
		
		
	BufferedWriter bw = new BufferedWriter(new FileWriter("aulaAlura_Saida2.txt"));
		
	bw.write("Esta é mais uma forma de gerar arquivo ");
	bw.write(" Utilizando a classe FileWriter");
	bw.newLine();	// PULA PARA NOVA LINHA
	bw.newLine();	// PULA PARA NOVA LINHA
	bw.write(" Neste código também é gerada nova linha ");
	bw.write(System.lineSeparator()); // OU GERA NOVA LINHA UTLIZANDO JAVA.LANG
	bw.write("     Utilizando tanto o newLine() como também System.lineSeparator() do java.lang");
	bw.newLine();
	bw.write(System.lineSeparator());
	bw.write("FIM");
	
	
	bw.close();
	
	}

}
