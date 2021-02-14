package br.com.meuprojeto.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestandoListas {

	public static void main(String[] args) {
		
		String curso1 = "Python";
		String curso2 = "Azure";
		String curso3 = "Java";
		
		List<String> lista = new ArrayList<>();
		lista.add(curso1);
		lista.add(curso2);
		lista.add(curso3);
		
		System.out.println("A nossa lista eh " + lista);
		
		lista.remove(curso2); // ou lista.remove(1);
		System.out.println("Depois de remover o segundo item, fica: " + lista);
		lista.add(curso2);
		
		// Usamos o metodo get() para acessar os itens da lista a partir do seu index
		System.out.println("O primeiro curso da lista eh o: " + lista.get(0));
		
		// Percorrendo a lista com o for tradicional
		System.out.println("Percorrendo a lista com o for tradicional: ");
		for(int i = 0; i < lista.size(); i++) {
			System.out.println((i+1) + " - " + lista.get(i));
		}
		
		// Percorrendo a lista com o foreach de uma lista		
		System.out.println();
		System.out.println("Percorrendo a lista com o foreach de uma lista: ");
		
		int j = 1;
		for(String curso : lista) {
			System.out.println(j + " - " + curso);
			j++;
		}
		
		Collections.sort(lista);
		System.out.println("A nossa lista ordenada fica assim: " + lista);		

	}
}