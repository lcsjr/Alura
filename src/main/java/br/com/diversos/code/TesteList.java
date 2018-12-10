package br.com.diversos.code;

import java.util.ArrayList;

public class TesteList {

	public static void main(String[] args) {

		ArrayList<String> linha = new ArrayList<>();
	
		for (int i = 0; i<10;i++) {
			linha.add("");
		}
		
		linha.set(2, "Teste 2");
		linha.set(5, "Teste 5");
		linha.set(3, "Teste 3");
		linha.set(0, "Teste 0");
		
		
		linha.forEach(l->{
			System.out.println("-"+l);
		});
		
		
		
	}

}
