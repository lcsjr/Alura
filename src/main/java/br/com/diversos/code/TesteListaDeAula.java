package br.com.diversos.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TesteListaDeAula {

	public static void main(String[] args) {

		Aula a1 = new Aula("Revistando as ArrayLists", 21);
		Aula a2 = new Aula("Listas de objetos", 20);
		Aula a3 = new Aula("Relacionamento entre listas e objetos", 15);
		
		ArrayList<Aula> aulas = new ArrayList<>();
		aulas.add(a1);
		aulas.add(a2);
		aulas.add(a3);
		
		System.out.println(aulas);
		
		// Ordenacao usando o comparable da classe
		Collections.sort(aulas);
		System.out.println(aulas);

		// 1 - customizando o jeito de ordenacao atraves do Colletions 
		Collections.sort(aulas, Comparator.comparing(Aula::getTempo));
		System.out.println(aulas);

		// 2 - customizando o jeito de ordenacao atraves da propria List
		aulas.sort(Comparator.comparing(Aula::getTempo));
		System.out.println(aulas);
	}

}
