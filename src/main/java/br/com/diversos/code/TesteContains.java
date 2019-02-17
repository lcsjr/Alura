package br.com.diversos.code;

import lombok.Getter;

public class TesteContains {

	public static void main(String[] args) {

		FonteDados saida = new FonteDados();
		
		saida.setDados("luiz");
		saida.setDados("carlos");
		saida.setDados("santos");
		saida.setDados("junior");
		
		System.out.println(saida.getDados());
		System.out.println("----------------");
		System.out.println(saida.getDados().contains("carlos"));
		System.out.println("----------------");
		
		if ( !saida.getDados().contains("carlos")) {
			saida.setDados("carlos");
		}
			
		System.out.println(saida.getDados());
	}
}

@Getter
class FonteDados {
	
	String dados = "" ;

	public void setDados(String dados) {
		this.dados += dados +'\n';
	}

}