package br.com.diversos.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TesteCom_Iterator {

	public static void main(String[] args) {
		
		
		System.out.println("Exemplo de uso de Iterator: ");
		System.out.println();
		
		List<String> nomesComArrayList = new ArrayList<>();
		nomesComArrayList.add("Super Mario");
		nomesComArrayList.add("Yoshi"); 
		nomesComArrayList.add("Donkey Kong"); 

		Iterator<String> it1 = nomesComArrayList.iterator();

		while(it1.hasNext()) {
		  System.out.println(it1.next());
		}
		
		System.out.println("------------------------------------------------------");

		Set<String> nomesComHashSet = new HashSet<>();
		nomesComHashSet.add("Super Mario");
		nomesComHashSet.add("Yoshi"); 
		nomesComHashSet.add("Donkey Kong"); 

		Iterator<String> it2 = nomesComHashSet.iterator();

		while(it2.hasNext()) {
		  System.out.println(it2.next());
		}
	}

}
