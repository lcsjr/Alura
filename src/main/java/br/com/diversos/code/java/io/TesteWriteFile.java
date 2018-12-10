package br.com.diversos.code.java.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TesteWriteFile {

	public static void main(String[] args) throws IOException {

	// Abaixo Fluxo de leitura de arquivo
	OutputStream fos = new FileOutputStream("aulaAlura_Saida.txt"); // abre em bytes
	Writer wsr = new OutputStreamWriter(fos);
	BufferedWriter bw = new BufferedWriter(wsr);
	
	bw.write("Teste");
	bw.newLine();
	bw.write("Saidaaa");
	
	
	bw.close();
	
	}

}
