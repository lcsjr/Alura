package br.com.diversos.code;

public class TesteString {

	public static void main(String[] args) {

		String curso1 = "Java";
		String curso2 = new String("PLSQL");
		StringBuilder cursoCompleto = new StringBuilder();
		
		if (cursoCompleto.toString().isEmpty()) {
			
			cursoCompleto.append("Prezado Aluno, " + System.lineSeparator());
			cursoCompleto.append("O curso de " + curso1+ " esta sendo realizado na alura com carga de 220 horas." +System.lineSeparator());
		}

		if (!cursoCompleto.toString().contains(curso2)) {
			cursoCompleto.append("O curso "+curso2+" esta sendo realizado presencialmente na KaSolution."+System.lineSeparator());
			cursoCompleto.append("	# A continuação será também pela Alura.");
		}
		
		System.out.println(cursoCompleto.toString()+System.lineSeparator());
		
		System.out.println("CharAt: " );
		for(int i=0; i<curso1.length();i++) {
			System.out.println(curso1.charAt(i));
		}
		
		int posIni = 2;
		int posFim = posIni+3;
		System.out.println(System.lineSeparator()+"Substring: " + curso2.substring(posIni, posFim));
		
		char ref = 'Q';
		System.out.println("Em " +curso2 + " a letra " +ref + " esta na posicao : " + curso2.indexOf(ref));
		
		
		
	}

}
