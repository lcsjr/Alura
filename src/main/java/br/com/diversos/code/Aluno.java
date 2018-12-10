package br.com.diversos.code;

import java.util.Locale;

import lombok.Getter;

@Getter
public class Aluno {

	private String nome;
	private int numeroMatricula;
	
	public Aluno(String nome, int numeroMatricula) {
		if(nome == null) {
			throw new NullPointerException("Nome não pode ser nulo.");
		}
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}
	
	@Override
	public String toString() {
		String saida = String.format(new Locale("pt","BR"), "Aluno: %-25s  Matricula: %10s.", nome, numeroMatricula);
		return saida ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numeroMatricula;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroMatricula != other.numeroMatricula)
			return false;
		return true;
	}
}
