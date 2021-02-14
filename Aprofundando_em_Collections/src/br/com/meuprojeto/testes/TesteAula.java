package br.com.meuprojeto.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.meuprojeto.classes.Aula;

public class TesteAula {

	public static void main(String[] args) {
		
		Aula a1 = new Aula(1, "Variaveis", 10);
		Aula a2 = new Aula(2, "Laços", 5);
		Aula a3 = new Aula(3, "POO", 30);
		
		List<Aula> lista = new ArrayList<>();
		
		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		
		System.out.println(lista);
		
		// Ordena de acordo com a ordem natural dos objetos da lista, definida com a interface Comparable na classe do objeto.
		Collections.sort(lista);
		System.out.println(lista);

		lista.sort(Comparator.comparing(Aula::getDuracao)); // Esta maneira de realizar sort foi introduzida no Java 8
		System.out.println(lista);
	}
}
