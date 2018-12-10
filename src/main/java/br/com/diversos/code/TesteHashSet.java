package br.com.diversos.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TesteHashSet {

	public static void main(String[] args) {

		Set<String> nomes = new HashSet<String>();
		nomes.add("Luiz");
		nomes.add("Santos");
		nomes.add("Junior");
		nomes.add("Carlos");
		
		System.out.println(nomes);
		nomes.add("Carlos"); // NAO PERMITE INSERIR ELEMENTO REPETIDOS
		System.out.println(nomes);
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("			Carlos existe? " + ( nomes.contains("Carlos") ? " Sim" : "Não"	)	);
		System.out.println("---------------------------------------------------------------");
		
		nomes.forEach(nome -> {
			System.out.print(nome+" ");
		});
		System.out.println();
		
		System.out.println( concatenaString(nomes) );
		
		List<String> listaNomes = new ArrayList<String>(nomes);
		Collections.sort(listaNomes);
		System.out.println(listaNomes);
		
		
	}
	
	public static String concatenaString(Set<String> sets) {
		
		String saida = "";
		
		for (String s : sets) {
			saida += s + " ";
		}
		
		return saida;
	}

}
