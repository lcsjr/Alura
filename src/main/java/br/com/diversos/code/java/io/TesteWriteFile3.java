package br.com.diversos.code.java.io;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class TesteWriteFile3 {

	private static String fileOut = "aulaAluraSaida3.txt";
	
	public static void main(String[] args) throws IOException {

	// Abaixo Fluxo de leitura de arquivo
//	OutputStream fos = new FileOutputStream("fileOut"); // abre em bytes
//	Writer wsr = new OutputStreamWriter(fos);
//	BufferedWriter bw = new BufferedWriter(wsr);
		
		
//	BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
		
		PrintStream ps = new PrintStream(fileOut);
		
		ps.println("Esta é mais uma forma de gerar arquivo ");
		ps.println(" utilizando PrintStream");
		ps.println();
		ps.println();
		ps.println("Final do arquivo!");
		
		ps.close();
		
		
		PrintWriter pw = new PrintWriter(fileOut+"_1");
		
		pw.println("Esta é mais uma forma de gerar arquivo ");
		pw.println(" utilizando PrintWriter ");
		pw.println();
		pw.println();
		pw.println("Final do arquivo!");
		
		pw.close();
	
	}

}
