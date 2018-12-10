package br.com.diversos.code;

public class TesteCurso {
	
	private static String excecoes = "Intervalo";

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");
		
		//List<Aula> aulas = javaColecoes.getAulas();
		//System.out.println(aulas);
		
		// subistituido pelo metodo adiciona
//		javaColecoes.getAulas().add(new Aula( "Trabalahdno com ArrayLis",21));
		
		javaColecoes.Adiciona(new Aula( "Aula1",21));
		javaColecoes.Adiciona(new Aula( "Aula2",20));
		javaColecoes.Adiciona(new Aula( "Intervalo",30));
		javaColecoes.Adiciona(new Aula( "Aula3",22));
		
		Aluno a1 = new Aluno("Luiz Santos", 23411);
		Aluno a2 = new Aluno("Carlos Junior", 42311);
		Aluno a3 = new Aluno("Junior Santos", 12311);
		
		javaColecoes.matricular(a1);
		javaColecoes.matricular(a2);
		javaColecoes.matricular(a3);
		
		javaColecoes.getAlunos().forEach(aluno->{
			System.out.println(aluno);	
		});
		
		System.out.println("Total de Alunos: " + javaColecoes.getAlunos().size());
		System.out.println();
		
		System.out.println("Aluno Carlos Junior esta matriculado?");
		System.out.println(javaColecoes.alunoMatriculado(a1) + "( por ser o msmo objeto que anteriormente foi adicionado em alunos, deu certo.");

		Aluno novoAluno = new Aluno("Carlos Junior",23411);
		System.out.println("Aluno Carlos Junior esta matriculado?");
		System.out.println(javaColecoes.alunoMatriculado(novoAluno) + " ( é necessário reescrever os metodos equals() e hashCode() para que essa "
				+ "verificação dê certo, pois senão a comparação será por objeto.)" );

		
		
		System.out.println();
		System.out.println(javaColecoes.getAulas());
		System.out.println("---------------------------------------------------------------");
		System.out.println("		Programando usando conceito de Lambdas			 "		);
		System.out.println("---------------------------------------------------------------");
		System.out.println();
		System.out.println("Todas as Aulas: ");
		// lambda
		javaColecoes.getAulas().forEach(aula->System.out.println(aula.getTitulo()));
		System.out.println("Tempo total das aulas: " + javaColecoes.getTempoTotal());
		System.out.println();
		
		System.out.println("Imprimindo o toString do objeto:");
		javaColecoes.getAulas().forEach(System.out::println);
		System.out.println();
		
		System.out.println("Filtrando aulas com IF:");
		javaColecoes.getAulas().forEach(aula->{
			if (!excecoes.equals(aula.getTitulo() ) ) {
				System.out.println(aula.getTitulo());
			}
		});
	
		System.out.println();
		System.out.println("Filtrando com stream().filter:");
		javaColecoes.getAulas().stream().filter( aula->aula.getTitulo().contains(excecoes)).forEach(System.out::println);		
		
		System.out.println();
		
		System.out.println(javaColecoes);
		
	}

}
