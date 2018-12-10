package br.com.diversos.code;

import java.util.Locale;

import lombok.Getter;

@Getter
public class Aula implements Comparable<Aula>{

	private String titulo;
	private int tempo;

	public Aula(String titulo, int tempo) {
		super();
		this.titulo = titulo;
		this.tempo = tempo;
	}

	@Override
	public String toString() {
		String saida = String.format( new Locale("pt", "BR") , "O Título da Aula: %s (%s min) " , titulo, tempo) ;
		
		//return "Aula (titulo=" + titulo + ", tempo=" + tempo + ")";
		return saida;
	}

	@Override
	public int compareTo(Aula outraAula) {
		return this.titulo.compareTo(outraAula.titulo);
	}
}
