package br.com.diversos.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TesteOrdenaUnModifiable {

	public static void main(String[] args) {
		System.out.println("---------------------------------------------------------------");
		System.out.println("		Ordenando um Collections.unModifiable			 ");
		System.out.println("---------------------------------------------------------------");

		Curso curso = new Curso("Java", "Paulo Silveira - Alura");

		curso.Adiciona(new Aula("Aula1", 25));
		curso.Adiciona(new Aula("Aula2", 27));
		curso.Adiciona(new Aula("Intervalo", 15));
		curso.Adiciona(new Aula("Aula3", 31));
		curso.Adiciona(new Aula("Aula4", 26));

		/*
		 * Ordenando um objeto definido como 'não modificado'.
		 * Instrução: Passa o objeto no construtor do ArrayList e a nova list pode ser modificada sem que haja modifique a original
		 */
		List<Aula> aulas = new ArrayList<Aula>(curso.getAulas());
		
		System.out.println("Ordenacao de insercao: ");
		System.out.println(aulas);
		System.out.println();
		
		System.out.println("Ordenacao padrao: ");
		Collections.sort(aulas);
		System.out.println(aulas);
		System.out.println();
		
		aulas.sort(Comparator.comparing(Aula::getTempo ));
		System.out.println("Ordenacao pelo atributo tempo: ");
		System.out.println(aulas);
		System.out.println();
		
		System.out.println("Ordenacao pelo atributo titulo: ");
		aulas.sort(Comparator.comparing(Aula::getTitulo ));
		System.out.println(aulas);
		System.out.println();
	}

}
