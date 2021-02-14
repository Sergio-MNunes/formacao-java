package br.com.meuprojeto.testes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.meuprojeto.classes.Aula;
import br.com.meuprojeto.classes.Curso;

public class TesteCurso {

	public static void main(String[] args) {
		Curso cursoDeColecoes = new Curso("Java Collections", "Sergio");
		
		System.out.println(cursoDeColecoes.getAulas());
		
		// A linha abaixo da erro, pois o metodo getAulas retorna um objeto imutavel, pois o definimos como Collections.unmodifiableList
		// cursoDeColecoes.getAulas().add(new Aula(1, "nome qualquer de aula", 23));  
		cursoDeColecoes.adiciona(new Aula(1, "Aprendendo sobre ArrayLists", 19));
		cursoDeColecoes.adiciona(new Aula(2, "Aprendendo sobre LinkedLists", 15));
		cursoDeColecoes.adiciona(new Aula(3, "Aprendendo sobre HashSets", 17));
		cursoDeColecoes.adiciona(new Aula(4, "Ainda sobre ArrayLists", 8));
		
		System.out.println(cursoDeColecoes.getAulas());
		
		// eh possivel criar uma nova lista passando como parametro pro construtor uma lista ja existente. Desta forma, a nova lista sera criada a imagem da existente.
		List<Aula> copiaDeAulas = new ArrayList<>(cursoDeColecoes.getAulas()); 

		copiaDeAulas.sort(Comparator.comparing(Aula::getDuracao));
		System.out.println(copiaDeAulas);
		
		System.out.println("Tempo do curso: " + cursoDeColecoes.getTempoTotal() + " minutos.");
		System.out.println(cursoDeColecoes);
	}
	
	
}
