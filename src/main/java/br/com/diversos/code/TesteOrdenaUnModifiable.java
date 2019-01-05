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
		 * Ordenando um objeto definido como 'não modificado'. Instrução: Passa o objeto
		 * no construtor do ArrayList e a nova list pode ser modificada sem que haja
		 * modifique a original
		 */
		List<Aula> aulas = new ArrayList<Aula>(curso.getAulas());

		System.out.println("Ordenacao de insercao: ");
		System.out.println(aulas);
		System.out.println();

		System.out.println("Ordenacao padrao: ");
		Collections.sort(aulas);
		System.out.println(aulas);
		System.out.println();

		aulas.sort(Comparator.comparing(Aula::getTempo));
		System.out.println("Ordenacao pelo atributo tempo: ");
		System.out.println(aulas);
		System.out.println();

		System.out.println("Ordenacao pelo atributo titulo: ");
		aulas.sort(Comparator.comparing(Aula::getTitulo));
		System.out.println(aulas);
		System.out.println();

		List<String> nomes = new ArrayList<>();
		nomes.add("Luiz Carlos Santos Junior");
		nomes.add("Luiz Carlos");
		nomes.add("Luiz Carlos dos Santos");

		System.out.println("Ordenação personalizada: ");
		Comparator<String> comparadorPorTamanho = new ComparadorPorTamanho();
		nomes.sort(comparadorPorTamanho);
		System.out.println(nomes);

		System.out.println("---------------------------------------------------");
		System.out.println("Ordenação personalizada com conceito de LAMBDA: ");
		nomes.sort((s1, s2) -> {
			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;

			return 0;
		});
		System.out.println(nomes);
		
		System.out.println();
		System.out.println("Ou... melhor ainda abaixo:");
		System.out.println("Ordenação personalizada com conceito de LAMBDA: ");
		nomes.sort((s1, s2) -> Integer.compare(s1.length() , s2.length()));
		System.out.println(nomes);

	}

}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;

		return 0;
	}

}