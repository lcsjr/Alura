package br.com.diversos.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TesteForEach {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");

		System.out.println("Jeito Antigo:");
		for (String p : palavras) {
			System.out.println("Nome:" + p);
		}

		System.out.println();
		System.out.println("Novo Jeito com conceito de nova class do tipo Consumer<T> e definindo o metodo de ação:");
		System.out.println();

		Consumer<String> imprimir = new ImprimeLista();
		palavras.forEach(imprimir);

		System.out.println("Agora utilizando o conceito de classe anônima:");
		Consumer<String> imprimir2 = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		};
		palavras.forEach(imprimir2);
		
		System.out.println();
		System.out.println("Agora aplicando o mesmo conceito dentro do forEach():");
		palavras.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		} );
		
		System.out.println();
		System.out.println("Agora o lambda para simplificar o código no forEach():");
		palavras.forEach ((String s) -> {
			System.out.println(s);
		});
		
		System.out.println();
		System.out.println("Com lambda dá para simplificar mais ainda o código no forEach():");
		palavras.forEach (s -> System.out.println(s) );
		
		System.out.println();
		System.out.println("Com Lambda o código fica mais legível e prático para desenvolver!!! ");
		
		
		
		
		
		System.out.println("Todos funcionam!!");
	}

}

class ImprimeLista implements Consumer<String> {

	@Override
	public void accept(String s) {
		System.out.println("Nome: " + s);
	}

}
