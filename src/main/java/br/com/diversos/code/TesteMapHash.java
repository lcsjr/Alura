package br.com.diversos.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TesteMapHash {

	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

		javaColecoes.Adiciona(new Aula("Aula1", 21));
		javaColecoes.Adiciona(new Aula("Aula2", 20));
		javaColecoes.Adiciona(new Aula("Intervalo", 30));
		javaColecoes.Adiciona(new Aula("Aula3", 22));

		Aluno a1 = new Aluno("Luiz Santos", 10);
		Aluno a2 = new Aluno("Davi Luiz Santos Gomes", 20);
		Aluno a3 = new Aluno("Cinthia Gomes Santos", 30);

		javaColecoes.matricular(a1);
		javaColecoes.matricular(a2);
		javaColecoes.matricular(a3);
		
		System.out.println("Percorrendo todos...");
		javaColecoes.getMatriculaPraAluno().keySet().forEach(m -> {
	            System.out.println(javaColecoes.getMatriculaPraAluno().get(m));
	        });
		
		
		List<Integer> pesquisaPor = new ArrayList<>();
		pesquisaPor.add(10);
		pesquisaPor.add(30);
		pesquisaPor.add(20);
		pesquisaPor.add(65);
		
		System.out.println("\nPesquisando por matrícula:");
		for (Integer i : pesquisaPor) {
			Aluno aluno = javaColecoes.buscaAlunoPelaMatricula(i);
			System.out.println( buscarMatricula(aluno) );
			System.out.println("--------------------");
		}
		
	}
	
	public static String buscarMatricula( Aluno aluno) {
		if (aluno == null )
				return "Nao encontrado";
						
		String mensagem	=	String.format(new Locale("pt","BR"),"\n Matrícula pesquisada: %s \n\n Aluno: %s", aluno.getNumeroMatricula(), aluno.getNome() );
		
		return mensagem;
	}

}
