package br.com.diversos.code.java.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class TesteScanner {
	
	private static String fileIn = "contas.csv";
	private static String fileOut = "contasFormatadas.txt";

	public static void main(String[] args) throws IOException {

		PrintWriter pw = new PrintWriter(fileOut);
		
	
		Scanner scanner = new Scanner(new File( fileIn ));
		
		boolean existe = scanner.hasNextLine();
		System.out.println("existe próxima linha ? " + existe );
		System.out.println();
		while ( scanner.hasNextLine() ) {
			String linha = scanner.nextLine();
			//System.out.println("linha conforme consta no arquivo: " + linha);
			
			Scanner linhaScanner = new Scanner(linha);
			linhaScanner.useLocale(Locale.US);
			linhaScanner.useDelimiter("\\|");
			
			String tipo = linhaScanner.next();
			int agencia = linhaScanner.nextInt();
			int numConta = linhaScanner.nextInt();
			String titular = linhaScanner.next();
			double saldo = linhaScanner.nextDouble();
			
			
			//String linhaSaida = String.format(new Locale("pt","BR"), "%-5s %-4d %-8d %-40s %8.2f", tipo, agencia, numConta, titular,saldo);
			String linhaSaida = String.format(new Locale("pt","BR"), "%-5s\t%-4d\t %-8d %-40s %8.2f", tipo, agencia, numConta, titular,saldo);
			System.out.println(linhaSaida);
			pw.println(linhaSaida);
			
		//	System.out.println("Tipo da Conta: "+ tipo + " Agencia: " + agencia + " Num Conta: " + numConta + " titular: " +titular + " Saldo: "+ saldo);
		//	System.out.println();
			
			linhaScanner.close();
			
		}
		
		System.out.println();
		System.out.println("existe próxima linha ? "  + scanner.hasNextLine());
		System.out.println("--------------------------------");
		
	
		pw.close();
		scanner.close();
	}

}
