package br.com.diversos.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TesteOrdenando1 {

	public static void main(String[] args) {

		String curso1 = "Java 8: Tire proveito dos novos recursos da linguagem";
		String curso2 = "Apache Camel";
		String curso3 = "Certificação Java SE 8 Programmer I";

		ArrayList<String> cursos = new ArrayList<>();
		cursos.add(curso1);
		cursos.add(curso2);
		cursos.add(curso3);

		Collections.sort(cursos);

		System.out.println(cursos);

		List<String> nomes = new ArrayList<>();
		nomes.add("Luiz Carlos Santos Junior");
		nomes.add("Luiz Carlos");
		nomes.add("Luiz Carlos dos Santos");

		System.out.println("Ordenação personalizada: ");
		Comparator<String> comparadorPorTamanho = new ComparadorPorTamanhoString();
		nomes.sort(comparadorPorTamanho);
		System.out.println(nomes);

	}

}

class ComparadorPorTamanhoString implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;

		return 0;
	}

}