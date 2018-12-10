package br.com.diversos.code;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import lombok.Getter;

@Getter
public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new LinkedList<Aula>();
	private Set<Aluno> alunos = new HashSet<>();
	private Map<Integer, Aluno> matriculaPraAluno = new HashMap<>();

	public Curso(String nome, String instrutor) {
		super();
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public void Adiciona(Aula aula) {
		this.aulas.add(aula);
	}
	
	public void Remove(Aula aula) {
		this.aulas.remove(aula);
	}
	public List<Aula> getAulas(){
		// Usando esta colection unmodi... permitirá o retorno do objeto entretanto nao poderá ser modificado.
		return Collections.unmodifiableList(aulas);
	}

	public int getTempoTotal() {
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}
	
	@Override
	public String toString() {
		String saida = String.format(new Locale("pt","BR"), "O curso %s possui um total de %s minutos.", nome, this.getTempoTotal() );
		return saida;
	}

	public Set<Aluno> getAlunos(){
		return Collections.unmodifiableSet(alunos);
	}
	
	public void matricular(Aluno aluno) {
		this.alunos.add(aluno);
		this.matriculaPraAluno.put(aluno.getNumeroMatricula(), aluno);
	}

	public Boolean alunoMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno);
	}
	
	public Aluno buscaAlunoPelaMatricula(int numero) {
		return this.matriculaPraAluno.get(numero) ;
	}
	
}
